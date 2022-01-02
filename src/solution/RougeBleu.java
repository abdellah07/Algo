package solution;

import graphe.ClasseInstance;
import graphe.Graphe;
import graphe.Sommet;
import graphe.Vecteur;

import java.util.List;

public class RougeBleu {
    public static void main(String[] args) {
        ClasseInstance cI = new ClasseInstance(0.5, 0.5);
    }

    Graphe resolve(Graphe graphe){
        for (Sommet sommet: graphe.getListeSommets()) {
            if(sommet.isRed()) {
                List<Sommet> sommetsEntrant = graphe.getSommetEntrants(sommet);
                for (Sommet sommetEntrant: sommetsEntrant){
                    if (graphe.getVecteur(sommet,sommetEntrant).isPresent()) {
                        Vecteur vecteur = graphe.getVecteur(sommet,sommetEntrant).get();
                    }
                }
            }
        }
        return graphe;
    }
}
