# ExercIcio-UDP 📝

  ✅ Fazer uma aplicação cliente-servidor para correção de questionários.
  
  ✅ O servidor deve ser capaz de receber várias conexões de sockets UDP de clientes
  simultaneamente (multithreading).
  
  ✅ O cliente envia ao servidor, vários datagramas contendo cada um uma resposta do tipo
  V ou F ao questionário, no seguinte formato:
  
  ✅ <número da questão>;<número alternativas>;<respostas>
    
    ▪ Exemplo:
    ▪ 1;5;VVFFV
    ▪ 2;4;VVVV
    
O servidor lê a mensagem e calcula o número de acertos e erros devolvendo uma resposta
simples:

  ✅ <número da questão>;<número acertos>;<número erros>

# ExercIcio-TCP 📝
  
  ✅ Desenvolver um servidor de arquivos multithreading para que múltiplos clientes
  possam solicitar o arquivo que deseja baixar passando o nome dele.
  
  ✅ Servidor pode retornar o arquivo (se existir) ou uma mensagem de arquivo não
  encontrado. Em ambos os casos deve fazer uso de sockets TCP. 
