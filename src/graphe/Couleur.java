package graphe;

public enum Couleur {
    ROUGE(0),
    BLEU(1);

    private int index ;

    private Couleur(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Couleur getCouleur(double p){
        double x = Math.random();
        if (x <= p) return Couleur.ROUGE;
        return Couleur.BLEU;
    }
}
