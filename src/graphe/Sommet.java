package graphe;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sommet implements Comparable<Sommet>{
    private int valeur;
    private Couleur couleur;

    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Sommet(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }


    public Sommet(int valeur, double p) {
        // p : la probabilité pour un sommet d'etre rouge
        // 1-p : la probabilité pour un sommet d'etre bleu
        this.valeur = valeur;
        this.couleur = Couleur.getCouleur(p);
    }

    public boolean isRed(){
        return couleur.equals(Couleur.ROUGE);
    }


    @Override
    public int compareTo(Sommet o) {
        if(o == this)
            return 0;
        if(o.isRed() && !this.isRed())
            return 1;
        if(!o.isRed() && this.isRed())
            return -1;
        if (!o.isRed() && !this.isRed())
            return 0;

        int value1 = 0;
        int value2 = 0;

        List<Vecteur> vectorSorta1 = ClasseInstance.graphe.getVecteurSortant(this);
        List<Vecteur> vectorSorta2 = ClasseInstance.graphe.getVecteurSortant(o);


        value1 += vectorSorta1.size();
        value2 += vectorSorta2.size();

        return Integer.compare(value1,value2);
    }
}
