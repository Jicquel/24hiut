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

    int nombreMoulesTrouvees = 0;


    //REMPLIT TABLEAU 
    for(int indice = this.INDICE_JOUEUR ; nombreMoulesTrouvees < p.getNombreMoules() ; indice++)
      for(int x = 0; x < p.getLargeur() && nombreMoulesTrouvees < p.getNombreMoules() ; x++)
        for(int y = 0 ; y < p.getHauteur() && nombreMoulesTrouvees < p.getNombreMoules()  ; y++)
        {
          //deplacement gauche
          //verifie si case de gauche en dehors tab
          if(x-1 >= 0)
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x-1][y] == indice)
            {
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
              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
                nombreMoulesTrouvees++;
            }

          }

        }

    int posXMoule = 0;
    int posYMoule = 0;
    int longueurChemin = 5000;

    //MAINTENANT ON CHECK LA MOULE
    for(Moule moule : p.getMoules())
    {
      if(tableau[moule.getX()][moule.getY()] != 0  && tableau[moule.getX()][moule.getY()] < longueurChemin)
      {
        posXMoule = moule.getX();
        posYMoule = moule.getY();
      }
    }

    String direction = this.trouverChemin(tableau, posXMoule, posYMoule, p.getLargeur(), p.getHauteur());
    return ""+ direction.charAt(0);


  }

  public String trouverChemin(int[][] tableau, int x, int y, int largeurTab, int hauteurTab)
  {
    int indice = tableau[x][y]; 

    String chemin = "";

    int posXActuelle = x;
    int posYActuelle = y;

    while(indice != this.INDICE_JOUEUR)
    {
      //GAUCHE 
      if(posXActuelle-1 >= 0)
      {
        if(tableau[posXActuelle-1][posYActuelle] == (indice -1))
          chemin = "E"+chemin;
      }

      //DROITE
      if(posXActuelle+1 < largeurTab)
      {
        if(tableau[posXActuelle+1][posYActuelle] == (indice -1))
          chemin = "O"+chemin;

      }

      //HAUT 
      if(posYActuelle-1 >= 0)
      {
        if(tableau[posXActuelle][posYActuelle-1] == (indice -1))
          chemin = "S"+chemin;
      }
      //BAS 
      if(posYActuelle < hauteurTab)
      {
        if(tableau[posXActuelle][posYActuelle+1] == (indice -1))
          chemin = "N"+chemin;
      }


    }

    return chemin;
  }
}

