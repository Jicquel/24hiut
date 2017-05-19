import java.io.*;
import java.net.*;


public class Client
{

  private final String nomEquipe = "C++ ce que c'était\n";
  private DataInputStream inputSocket;
  private DataOutputStream outputSocket;
  private BufferedReader readerIn;

  private String serverAddr;
  private int portServ;
  private String numeroEquipe;

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
    this.outputSocket.writeBytes(this.nomEquipe);

    this.numeroEquipe = this.readerIn.readLine();
    System.out.println(this.numeroEquipe);
  }

  public void play()
  {
    try{
      String stringPlateau = this.readerIn.readLine();
      //System.out.println("StringPlateau : "+stringPlateau);
      Algo algorithme = new Algo();
      Plateau p;
      String instruction;

        p = new Plateau(stringPlateau, Integer.parseInt(this.numeroEquipe));
      do
      { 
        p.majTab(stringPlateau);
        //System.out.println(p.toString());
        instruction = algorithme.deplacerJoueur(p)+"\n";
        //System.out.println(instruction);
        this.outputSocket.writeBytes(instruction);

        stringPlateau = this.readerIn.readLine();

      }while(!stringPlateau.equals("FIN"));
    }catch(IOException e)
    {
      System.out.println("play error");
    }
  }

}
