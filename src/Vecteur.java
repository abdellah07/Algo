public class Vecteur {
    private Couleur couleur;
    private SensVecteur sens;
    private Sommet sommet1;
    private Sommet sommet2;

    public Sommet getSommet1() {
        return sommet1;
    }
    public void setSommet1(Sommet sommet1) {
        this.sommet1 = sommet1;
    }

    public Sommet getSommet2() {
        return sommet2;
    }
    public void setSommet2(Sommet sommet2) {
        this.sommet2 = sommet2;
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public SensVecteur getSens() {
        return sens;
    }
    public void setSens(SensVecteur sens) {
        this.sens = sens;
    }

    public Vecteur(Couleur couleur, SensVecteur sens, Sommet sommet1, Sommet sommet2) {
        this.couleur = couleur;
        this.sens = sens;
        this.sommet1 = sommet1;
        this.sommet2 = sommet2;
    }

    public Vecteur(double q, double r, Sommet sommet1, Sommet sommet2) {
        if(sommet1.getValeur() > 0){

            this.sens = SensVecteur.getSens(r);
        }else{
            this.sens = SensVecteur.DROITE;
        }

        this.couleur = Couleur.getCouleur(q);

        this.sommet1 = sommet1;
        this.sommet2 = sommet2;
    }
}
