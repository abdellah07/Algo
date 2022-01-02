package graphe;

public class ClasseInstance {
    public static Graphe graphe;

    public ClasseInstance(double p, double q, double r) {
        graphe = new Graphe(p, q, r);
        nextStep();
    }

    public ClasseInstance(double p, double q) {
        graphe = new Graphe(p, q, 0.5);
        nextStep();
    }

    public void nextStep(){
        int sSommetsRouge = 0;
        int sVecteursRouge = 0;

        for(int i = 0; i < graphe.listeSommets.size() - 1; i++){
            if(graphe.listeSommets.get(i).getCouleur() == Couleur.ROUGE){
                sSommetsRouge += 1;
            }
        }

        for(int i = 0; i < graphe.listVecteurs.size() - 1; i++){
            if(graphe.getListVecteurs().get(i).getCouleur() == Couleur.ROUGE){
                sVecteursRouge += 1;
            }
        }

        System.out.println(graphe);
        System.out.println("sSommetsRouge : " + sSommetsRouge);
        System.out.println("sVecteursRouge : " + sVecteursRouge);
    }

    public void deleteSommet(int index){
        graphe.supprimerSommet(index);
        nextStep();
    }
}
