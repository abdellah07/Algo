package solution;

import graphe.ClasseInstance;
import graphe.Graphe;
import graphe.Sommet;
import graphe.Vecteur;

import java.util.*;

public class RougeBleu {
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

    static Graphe resolve(){
        Graphe graphe = ClasseInstance.graphe;
        do{
            List<Sommet> sommets = graphe.getListeSommets();
            Collections.sort(sommets);
            if(sommets.isEmpty())
                break;
            if (!sommets.get(0).isRed())
                break;
            graphe.supprimerSommet(sommets.get(0).getValeur());
        }while(true);
        return graphe;
    }


}
