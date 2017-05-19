

public class Plateau {
          private int[][] plateau;
          private Joueur[] pj;
          private Moule[] mou;
          private int largeur;
          private int hauteur;
          private int nbrjoueur;
          private int nbrmoule = 0;
          public final static int  DUNE = 5000;
          public final static int  SABLE = 5001;
          public final static int FRITE = 5002;
          public final static int BIERE =5003;
          public Plateau(String liste) {
                  String[] s = liste.split("x");
                largeur =Integer.parseInt(s[0]);
                  String[] ss = s[1].split("/");
                  hauteur=Integer.parseInt(ss[0]);
                  plateau = new int[largeur][hauteur];
                  String[] cases = ss[1].split("/");
                  int count=0;
                  String temp = "";
                  char c;
                  mou = new Moule[21];
                for(int ct = 0 ;ct<cases[0].length() ; ct++) {
                  c=cases[0].charAt(ct);
                            switch(c) {
                                  case 'D':
                                  plateau[count%largeur][((count-(count%largeur))/hauteur)]=DUNE;
                                  break;
                                  case 'S':
                                  plateau[count%largeur][((count-(count%largeur))/hauteur)]=SABLE;
                                  break;
                                  case 'F':
                                  plateau[count%largeur][((count-(count%largeur))/hauteur)]=FRITE;
                                  break;
                                  case 'B':
                                  plateau[count%largeur][((count-(count%largeur))/hauteur)]=BIERE;
                                  break;
                                  case '-':
                                  if(temp!="") {
                                    plateau[count%largeur][((count-(count%largeur))/hauteur)]=Integer.parseInt(temp)*-1;
                                    mou[nbrmoule]=new Moule(count%largeur,((count-(count%largeur))/hauteur),Integer.parseInt(temp));
                                    nbrmoule=nbrmoule+1;
                                    temp="";
                                  }
                                  count++;
                                  break;
                                  default:
                                    temp=temp+""+c;
                                  break;
                                }
                            }
                      String[] fc = ss[2].split("-");
                      ;
                      nbrjoueur=Integer.parseInt(fc[0]);
                      for(int i = 0;i<nbrjoueur;i++) {
                            String[] virgule = fc[i+1].split(",");
                            pj[i]=new Joueur(Short.parseShort(virgule[0]),Short.parseShort(virgule[1]));
                      }

                  }
                  public int getNombreMoules() {
                    return nbrmoule;
                  }
                  public Moule[] getMoules() {
                    return mou;
                  }
                  public int[][] getTableau() {
                      return plateau;
                  }

                  public String toString() {
                    String s = new String("X :" + largeur + "Y :"+hauteur);
                      s=s+"\n";
                    for(int i = 0 ; i < largeur ; i++) {
                      for(int j = 0;j< hauteur;j++) {
                            s=s+"|  "+plateau[j][i];
                      }
                      s=s+"\n";
                    }
                    for(int i =0;i<nbrjoueur;i++) {
                            s=s+"Joueur "+(i+1)+"Positions X :"+pj[i].getPositionX()+"Positions Y : " +pj[i].getPositionY();
                    }
                    return s;
                  }
                  }
