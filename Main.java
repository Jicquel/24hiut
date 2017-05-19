import java.io.IOException;
public class Main{

  public static void main(String[] args)
  {
  Client clt = new Client("10.62.255.180",1337);
  
  try{
  clt.connectToServer();
  }catch(IOException e)
  {
    System.out.println("Connection denied");
  }
  clt.play();
  System.out.println("fin main");

  

  }
}
