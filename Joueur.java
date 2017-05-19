
public class Joueur
{
  private  int points;
  public  int id;
  private  short frites;
  private  short bieres;
  private int numEquipe;

  private  short x;
  private  short y;

  public Joueur(short posx,  short posy, int id0, int numeroEquipe)
  {
    this.frites=0;
    this.bieres=0;
    this.points=0;
    this.x=posx;
    this.y=posy;
    this.id=id0;
    this.numEquipe = numeroEquipe;
  }


  public Boolean isItMe()
  {
    return this.numEquipe == this.id;
  }

  public void move( short posx,  short posy)
  {
    this.x=posx;
    this.y=posy;
  }

  public short getPositionX() {
    return x;
  }
  public short getPositionY() {
    return y;
  }
  public void grabMoule( short p)
  {
    this.points+=p;
  }

  public short getNombreBieres()
  {
    return this.bieres;
  }
  public short getNombreFrites()
  {
    return this.frites;
  }

  public void grabFrite()
  {
    this.frites++;
  }
  public void grabBiere()
  {
    this.bieres++;
  }
  public void useFrite()
  {
    this.frites--;
  }
  public void useBiere()
  {
    this.bieres--;
  }
  public int getId()
  {
    return this.id;
  }
}
