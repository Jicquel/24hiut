import java.io.*;
import java.net.*;


public class Client
{

  private final int nomEquipe = 32;
  private DataInputStream inputSocket;
  private DataOutputStream outputSocket;
  private String serverAddr;
  private int portServ;
  private int numeroEquipe;

  public Client(String serverAddr,int portServ)
  {
    this.serverAddr = serverAddr;
    this.portServ = portServ;
  }


  public void connectToServer() throws IOException {

    Socket socket = new Socket(this.serverAddr, this.portServ);

    this.inputSocket = new DataInputStream(socket.getInputStream());
    this.outputSocket = new DataOutputStream(socket.getOutputStream());

    //ENVOI NOM EQUIPE
    this.outputSocket.writeByte(this.nomEquipe);

    this.numeroEquipe = this.inputSocket.readInt();
    System.out.println(this.numeroEquipe);
     


  }

}
