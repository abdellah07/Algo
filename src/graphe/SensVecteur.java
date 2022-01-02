package graphe;

public enum SensVecteur {
    GAUCHE(0),
    DROITE(1);

    private int index ;

    private SensVecteur(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static SensVecteur getSens(double r){
        double x = Math.random();
        if (x <= r) return SensVecteur.GAUCHE;
        return SensVecteur.DROITE;
    }
}
