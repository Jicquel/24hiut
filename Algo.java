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


    Joueur monJoueur= null;
    for(Joueur joueur : p.getJoueurs())
    {
      if(joueur.isItMe())
        {
      monJoueur = joueur;
        }
    }
    tableau[monJoueur.getPositionX()][monJoueur.getPositionY()]= INDICE_JOUEUR;

    boolean mouleTrouvee = false;

    int posXMoule = 0;
    int posYMoule = 0;

    //REMPLIT TABLEAU 
    for(int indice = this.INDICE_JOUEUR ; !mouleTrouvee ; indice++)
    {
      for(int x = 0; x < p.getLargeur() && !mouleTrouvee; x++)
        for(int y = 0 ; y < p.getHauteur() && !mouleTrouvee ; y++)
        {
          //deplacement gauche
          //verifie si case de gauche en dehors tab
          if(x-1 >= 0)
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x-1][y] == indice)
            {

              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
              {
                posXMoule = x;
                posYMoule = y;
                mouleTrouvee=true;
              }


            }
          }
          //deplacement droite
          if(x+1 < p.getLargeur())
          {
            if(plateau[x][y] !=  Plateau.DUNE  && tableau[x][y] == 0 && tableau[x+1][y] == indice)
            {

              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
              {
                posXMoule = x;
                posYMoule = y;
                mouleTrouvee=true;
              }
            }
          }
          //deplacement haut
          if(y-1 >= 0)
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x][y-1] == indice)
            {

              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
              {
                posXMoule = x;
                posYMoule = y;
                mouleTrouvee=true;
              }

            }
          }
          //deplacement bas
          if(y+1 < p.getHauteur())
          {
            if(plateau[x][y] !=  Plateau.DUNE && tableau[x][y] == 0 && tableau[x][y+1] == indice)
            {

              tableau[x][y] = indice+1;
              if(plateau[x][y] <  0)
              {
                posXMoule = x;
                posYMoule = y;
                mouleTrouvee=true;
              }
            }

          }

        }


      //      this.afficheTableau(tableau);


    }
    String direction = this.trouverChemin(tableau, posXMoule, posYMoule, p.getLargeur(), p.getHauteur());
    String res = "";

      res = res+direction.charAt(0);

    if( monJoueur.getNombreBieres() > 0 &&  direction.length() > 1)
    {
      if(direction.length() >=  3)
             res = res+"-"+direction.charAt(1)+"-"+direction.charAt(2);
      else if(direction.length() == 2)
             res = res+"-"+direction.charAt(1)+"-C";

        res = "B-"+res;
   monJoueur.useBiere(); 
    }

    return res;


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

