import java.io.*;
import java.net.*;


public class Client
{

  private final int nomEquipe = 32;
  private DataInputStream inputSocket;
  private DataOutputStream outputSocket;
  private BufferedReader readerIn;

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
    this.readerIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));


    //ENVOI NOM EQUIPE
    this.outputSocket.writeByte(this.nomEquipe);

    this.numeroEquipe = this.inputSocket.readInt();
    System.out.println(this.numeroEquipe);
  }

  public void play()
  {
    try{

      String stringPlateau = this.readerIn.readLine();
      Algo algorithme = new Algo();
      Plateau p;
      do
      { 
        p = new Plateau(stringPlateau);
        this.outputSocket.writeBytes(algorithme.deplacerJoueur(p));

        stringPlateau = this.readerIn.readLine();
      }while(!stringPlateau.equals("FIN"));
    }catch(IOException e)
    {
      System.out.println("play error");
    }
  }

}
