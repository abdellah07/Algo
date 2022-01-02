package graphe;

import java.util.Objects;

public class Sommet {
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

    public boolean isRed(){
        return couleur.equals(Couleur.ROUGE);
    }
    public Sommet(int valeur, double p) {
        // p : la probabilité pour un sommet d'etre rouge
        // 1-p : la probabilité pour un sommet d'etre bleu
        this.valeur = valeur;
        this.couleur = Couleur.getCouleur(p);
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
}
