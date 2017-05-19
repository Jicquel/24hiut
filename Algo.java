import java.util.*;

public class Algo
{

  private final int INDICE_JOUEUR = 1;
  public Algo()
  {
  }

  public String deplacerJoueur(Plateau p)
  {
    int[][] plateau = p.getTableau();
    int[][] tableau = new int[p.getLargeur()][p.getHauteur()];

    Joueur[] joueurs = p.getJoueurs();

    tableau[joueurs[0].getPositionX()][joueurs[0].getPositionY()]= INDICE_JOUEUR;

    int nombreMoulesTrouvees = 0;


    //REMPLIT TABLEAU 
    for(int indice = this.INDICE_JOUEUR ; nombreMoulesTrouvees < p.getNombreMoules() ; indice++)
    {
      for(int x = 0; x < p.getLargeur() && nombreMoulesTrouvees < p.getNombreMoules() ; x++)
        for(int y = 0 ; y < p.getHauteur() && nombreMoulesTrouvees < p.getNombreMoules()  ; y++)
        {
          //deplacement gauche
          //verifie si case de gauche en dehors tab
          if(x-1 >= 0)
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x-1][y] == indice)
            {
              System.out.println("GAUCHE");
              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
                nombreMoulesTrouvees++;

            }
          }
          //deplacement droite
          if(x+1 < p.getLargeur())
          {
            if(plateau[x][y] !=  Plateau.DUNE  && tableau[x][y] == 0 && tableau[x+1][y] == indice)
            {
              System.out.println("DROITE");
              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
                nombreMoulesTrouvees++;
            }
          }
          //deplacement haut
          if(y-1 >= 0)
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x][y-1] == indice)
            {
              System.out.println("HAUT");
              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
                nombreMoulesTrouvees++;

            }
          }
          //deplacement bas
          if(y+1 < p.getHauteur())
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x][y+1] == indice)
            {
              System.out.println("BAS");
              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
                nombreMoulesTrouvees++;
            }

          }

        }
      System.out.println("Nombre moules : "+p.getNombreMoules());
      System.out.println("Nombre moules trouvees : "+nombreMoulesTrouvees);
      this.afficheTableau(tableau);
    }

    int posXMoule = 0;
    int posYMoule = 0;
    int longueurChemin = 5000;

    //MAINTENANT ON CHECK LA MOULE
    for(Moule moule : p.getMoules())
    {
      if(moule != null)
      {
        if(tableau[moule.getX()][moule.getY()] != 0  && tableau[moule.getX()][moule.getY()] < longueurChemin)
        {
          posXMoule = moule.getX();
          posYMoule = moule.getY();
        }
      }
    }
    String direction = this.trouverChemin(tableau, posXMoule, posYMoule, p.getLargeur(), p.getHauteur());
    System.out.println("bite");
    return ""+ direction.charAt(0);


  }

  public void afficheTableau(int[][] tableau)
  {
      for(int i=0;i<tableau.length;i++)
      {
        for(int j=0;j<tableau[i].length;j++)
        {
          System.out.print(tableau[i][j]+" | ");
        }
        System.out.print('\n');
      }
  }

  public String trouverChemin(int[][] tableau, int x, int y, int largeurTab, int hauteurTab)
  {
    int indice = tableau[x][y]; 

    String chemin = "";

    int posXActuelle = x;
    int posYActuelle = y;

    boolean found = false;
    while(indice != this.INDICE_JOUEUR)
    {
      found=false;
      //GAUCHE 
      if(posXActuelle-1 >= 0 && !found)
      {
        if(tableau[posXActuelle-1][posYActuelle] == (indice -1))
        {
          System.out.println("E");
          chemin = "E"+chemin;
          posXActuelle = posXActuelle-1;
          found = true;
        }
      }

      //DROITE
      if(posXActuelle+1 < largeurTab && !found)
      {
        if(tableau[posXActuelle+1][posYActuelle] == (indice -1))
        {
          System.out.println("O");
          chemin = "O"+chemin;
          posXActuelle = posXActuelle+1;
          found = true;

        }

      }

      //HAUT 
      if(posYActuelle-1 >= 0 && !found)
      {
        if(tableau[posXActuelle][posYActuelle-1] == (indice -1))
        {
          System.out.println("S");
          chemin = "S"+chemin;
          posYActuelle = posYActuelle-1;
          found = true;
        }
      }
      //BAS 
      if(posYActuelle < hauteurTab && !found)
      {
        if(tableau[posXActuelle][posYActuelle+1] == (indice -1))
        {
          System.out.println("N");
          chemin = "N"+chemin;
          posYActuelle = posYActuelle+1;
          found = true;
        }
      }
indice --;

    }

    return chemin;
  }
}

