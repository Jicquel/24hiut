

public class Plateau
{
	private int[][] plateau;
	private Joueur[] tabJoueurs;
	private Moule[] tabMoules;
	private int largeur;
	private int hauteur;
	private int nbrjoueur;
	private int nbrMoule = 0;
	public final static int  DUNE = 5000;
	public final static int  SABLE = 5001;
	public final static int FRITE = 5002;
	public final static int BIERE =5003;


	public Plateau(String blockCara)
	{
		majTab(blockCara);
	}

	public void majTab(String blockCara)
	{
		int i, j, k;
		int nbMoules=0;
		int nbJoueurs;
		Moule[] moules = new Moule[20];

		String[] decomp = blockCara.split("/");

		String[] taillesTab = decomp[0].split("x");
		largeur = Integer.parseInt(taillesTab[0]);
		hauteur = Integer.parseInt(taillesTab[1]);


		plateau = new int[largeur][hauteur];

		String[] terrain = decomp[1].split("-");

		for(i=0 ; i<terrain.length ; i++)
		{
			c=terrain[i];
			switch(c)
			{
				case 'D':
					plateau[count%largeur][((count-(count%largeur))/largeur)]=DUNE;
					break;
				case 'S':
					plateau[count%largeur][((count-(count%largeur))/largeur)]=SABLE;
					break;
				case 'F':
					plateau[count%largeur][((count-(count%largeur))/largeur)]=FRITE;
					break;
				case 'B':
					plateau[count%largeur][((count-(count%largeur))/largeur)]=BIERE;
					break;
				default:
					plateau[count%largeur][((count-(count%largeur))/largeur)]=Integer.parseInt(i)*-1;
					moules[nbMoules] = new Moule(count%largeur, ((count-(count%largeur))/largeur), Integer.parseInt(i));
					nbMoules++;
					break;
			}
		}

		String[] paramJoueurs = decomp[2].split("-");

		nbJoueurs = Integer.parseInt(paramJoueurs[0]);

		this.tabJoueurs = new Joueur[nbJoueurs];

		for(i=0 ; i<nbJoueurs ; i++)
		{
			String coords = paramJoueurs[i].split(",");
			this.tabJoueurs[i] = New Joueur(Integer.parseInt(coords[0]), integer.parseInt(coords[1]));
		}

		this.tabMoules = copyOf(moules, nbMoules);
	}

	public int getHauteur()
	{
		return this.hauteur;
	}

	public int getLargeur()
	{
		return this.largeur;
	}

	public int getNombreMoules()
	{
		return nbrmoule;
	}
	public Moule[] getMoules()
	{
		return tabMoules;
	}
	public int[][] getTableau()
	{
		return plateau;
	}
	public Joueur[] getJoueurs()
	{
		return this.tabJoueurs;
	}

	public String toString()
	{
		String chaine = new String("X :" + largeur + "Y :"+hauteur);
		chaine=chaine+"\n";
		for(int i = 0 ; i <hauteur ; i++)
		{
			for(int j = 0;j< largeur;j++)
			{
				chaine=chaine+"|  "+plateau[j][i];
			}
			chaine=chaine+"\n";
		}
		for(int i =0;i<nbrjoueur;i++)
		{
			chaine=chaine+"Joueur "+(i+1)+"Positions X :"+tabJoueurs[i].getPositionX()+"Positions Y : " +tabJoueurs[i].getPositionY();
		}
		return chaine;
	}
}
