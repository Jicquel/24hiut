import java.utils;

public class Joueur
{
	private unsigned int points;
	private unsigned short frites;
	private unsigned short bieres;

	private unsigned short x;
	private unsigned short y;

	public Joueur(unsigned short posx, unsigned short posy)
	{
		this.frites=0;
		this.bieres=0;
		this.points=0;
		this.x=posx;
		this.y=posy;
	}

	public void move(unsigned short posx, unsigned short posy)
	{
		this.x=posx;
		this.y=posy;
	}

	public void grabMoule(unsigned short p)
	{
		this.points+=p;
	}

	public void grabFrite()
	{
		this.frites++;
	}
	public void grabBiere()
	{
		this.bieres++;
	}
	public void grabFrite()
	{
		this.frites--;
	}
	public void grabBiere()
	{
		this.bieres--;
	}
}
