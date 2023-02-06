import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a questão: ");
        String questao = sc.nextLine();

        byte[] message = questao.getBytes();

        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(message, message.length, address, 9876);
        socket.send(packet);
        byte[] buf = new byte[1024];
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println(received);
        socket.close();
    }
}
