import java.util.*;
import java.lang.Math;
import java.io.*;
public class Checker implements
java.io.Serializable
{
    public Checker()
    {

    }

    public int checkWin(ArrayList<Feld> Felder, TicTacToe toe){
        int gewonnen = -1;
        int Dim = Felder.get(0).getK().size();
        for(int sp = 0; sp < 2; sp++){
            for(int j=0; j<(int)(Math.pow(3,Dim-1)/2)+Math.pow(3,Dim-1) ; j++){
                Feld letztesFeld = Felder.get(Felder.size()-1);
                int[] P = new int[Felder.get(0).getK().size()];
                int[] D = new int[Felder.get(0).getK().size()];

                for (int i=0;i<Dim;i++){
                    if( (j/(int)(Math.pow(3,i))) % 3 == 0){P[i] = 0;D[i] = 1;}
                    else if((j/(int)(Math.pow(3,i)))%3==1){P[i] = letztesFeld.gC(i);D[i] = 0;}
                    else{P[i] = 4;D[i] = -1;}
                }

                for(int i=0; i<Felder.size() -1;i++){
                    if(Felder.get(Felder.size() -1).spieler() == sp){
                        if((letztesFeld.gC(0) + D[0] == Felder.get(i).gC(0) && letztesFeld.gC(1) + D[1] == Felder.get(i).gC(1)) && 
                        letztesFeld.gC(2) + D[2] == Felder.get(i).gC(2) && letztesFeld.gC(3) + D[3] == Felder.get(i).gC(3) ||
                        (letztesFeld.gC(0) - D[0] == Felder.get(i).gC(0) && letztesFeld.gC(1) - D[1] == Felder.get(i).gC(1)) && 
                        letztesFeld.gC(2) - D[2] == Felder.get(i).gC(2) && letztesFeld.gC(3) - D[3] == Felder.get(i).gC(3)){

                            for (int m=0;m<Dim;m++){
                                if( (j/(int)(Math.pow(3,m))) % 3 == 0){P[m] = 0;}
                                else if((j/(int)(Math.pow(3,m)))%3==1){P[m] = letztesFeld.gC(m);}
                                else{P[m] = 4;}
                            }
                            int zaehler = 0;
                            for(int k=0;k<5;k++){
                                if(toe.Spielfeld(P[0],P[1],P[2],P[3]) == sp){
                                    zaehler ++;
                                }
                                P[0] += D[0];
                                P[1] += D[1];
                                P[2] += D[2];
                                P[3] += D[3];
                            }
                            if(zaehler == 5)
                            {
                                gewonnen = sp;
                            }
                        }
                    }
                }
            }
        }
        return gewonnen;
    }
}