import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9876);

        while(true) {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            new Thread(() -> {
                String received = new String(packet.getData(), 0, packet.getLength());
                String[] parts = received.split(";");

                Integer qtdQuestao = Integer.parseInt(parts[1]);

                int qtdAcertos = 0;
                for(int i = 0; i < parts[2].length(); i++) {
                    if(parts[2].charAt(i) == 'V') qtdAcertos++;
                }

                String resposta = "";
                resposta += parts[0];
                resposta += ";";
                resposta += qtdAcertos;
                resposta += ";";
                resposta += qtdQuestao-qtdAcertos;

                byte[] response = resposta.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(response, response.length, packet.getAddress(), packet.getPort());
                try {
                    socket.send(responsePacket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }


    }
}
