package graphe;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sommet sommet = (Sommet) o;
        return valeur == sommet.valeur && couleur == sommet.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur, couleur);
    }

    @Override
    public int compareTo(Sommet o) {
        if(this==o)
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

        List<Vecteur> vectorRouge1 = vectorSorta1.stream().filter(vecteur -> vecteur.getCouleur().equals(Couleur.ROUGE)).collect(Collectors.toList());
        List<Vecteur> vectorRouge2 = vectorSorta2.stream().filter(vecteur -> vecteur.getCouleur().equals(Couleur.ROUGE)).collect(Collectors.toList());

        value1 += vectorRouge1.size();
        value2 += vectorRouge2.size();

        return Integer.compare(value1,value2);
    }
}
