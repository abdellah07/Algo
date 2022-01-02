package solution;

import graphe.ClasseInstance;
import graphe.Graphe;
import graphe.Sommet;
import graphe.Vecteur;

import java.util.*;

public class RougeBleu {

    private static int k = 0;
    public static void main(String[] args) {
        ClasseInstance cI = new ClasseInstance(0.5, 0.5);
        Graphe graphe = ClasseInstance.graphe;
        System.out.println("Nombre de rouge"+graphe.nombreDeRouge());
        System.out.println("Nombre de bleu"+graphe.nombreDeBleu());
        System.out.println("####################################################################################");
        System.out.println(resolve());
        System.out.println("####################################################################################");
        System.out.println("Nombre de rouge"+graphe.nombreDeRouge());
        System.out.println("Nombre de bleu"+graphe.nombreDeBleu());
    }

    static void reset(){
        k=0;
    }

    static int getNumber(){
        return k;
    }
    public static Graphe resolve(){
        Graphe graphe = ClasseInstance.graphe;
        do{
            List<Sommet> sommets = graphe.getListeSommets();
            Object[] sommets1 = sommets.toArray();
            Arrays.sort(sommets1);

            if(sommets.isEmpty())
                break;
            if (!((Sommet)sommets1[0]).isRed())
                break;
            graphe.supprimerSommet(((Sommet)sommets1[0]).getValeur());
            k++;
        }while(true);
        return graphe;
    }


}
