import java.util.ArrayList;
import java.util.List;

public class Graphe {
    List<Sommet> listeSommets;
    List<Vecteur> listVecteurs;

    public List<Vecteur> getListVecteurs() {
        return listVecteurs;
    }

    public Graphe(double p, double q, double r) {
        listeSommets = new ArrayList<Sommet>();
        listVecteurs = new ArrayList<Vecteur>();

        construireGraphe(p, q, r);
    }

    private void construireGraphe(double p, double q, double r){
        construireSommets(p);
        construireVecteurs(q, r);
    }

    private void construireSommets(double p){
        for(int i = 0; i < 100; i++){
            this.listeSommets.add(new Sommet(i, p));
        }
    }

    private void construireVecteurs(double q, double r){
        for(int i = 0; i < 99; i++){
            this.listVecteurs.add(new Vecteur(q, r, this.listeSommets.get(i), this.listeSommets.get(i+1)));
        }
    }

    public void supprimerSommet(int index){
        int indexSommet = findIndexSommet(index);

        if(indexSommet == -1){
            System.out.println("ce sommet n'existe pas");
            return;
        }
        else if(findSommet(index).getCouleur() == Couleur.BLEU){
            System.out.println("vous ne pouvez supprimer que les sommets de couleur bleu");
            return;
        }

        // changer la couleur des sommets visés par les flèches
        Vecteur v = findVecteur(index);
        int indexOfVecteur1 = -1;

        if(v != null){
            indexOfVecteur1 = listVecteurs.indexOf(v);

            Couleur c = v.getCouleur();
            if(indexOfVecteur1 > -1 && v.getSens() == SensVecteur.DROITE){
                v.getSommet2().setCouleur(c);
            }
        }

        v = findVecteur(index - 1);
        int indexOfVecteur2 = -1;

        if(v != null){
            indexOfVecteur2 = listVecteurs.indexOf(v);

            if(indexOfVecteur2 > -1 && indexSommet > 0){
                Couleur c1 = v.getCouleur();
                if(v.getSens() == SensVecteur.GAUCHE) {
                    v.getSommet1().setCouleur(c1);
                }
            }
        }

        listeSommets.remove(indexSommet);
        if(indexOfVecteur1 > -1) listVecteurs.remove(indexOfVecteur1);
        if(indexOfVecteur2 > -1 && indexSommet > 0){
            listVecteurs.remove(indexOfVecteur2);
        }
    }

    public Sommet findSommet(int index){
        for(int i = 0; i < listeSommets.size(); i++){
            if(listeSommets.get(i).getValeur() == index){
                return listeSommets.get(i);
            }
        }

        return null;
    }

    public Vecteur findVecteur(int valeur){
        for(int i = 0; i < listVecteurs.size(); i++){
            if(listVecteurs.get(i).getSommet1().getValeur() == valeur){
                return listVecteurs.get(i);
            }
        }

        return null;
    }

    public int findIndexSommet(int index){
        for(int i = 0; i < listeSommets.size(); i++){
            if(listeSommets.get(i).getValeur() == index){
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString(){
        String chaine = "";
        for(int i = 0; i < listeSommets.size() - 1; i++){
            int val =listeSommets.get(i).getValeur();
            if(listeSommets.get(i).getCouleur() == Couleur.ROUGE){
                chaine += "R" + val;
            }
            else{
                chaine += "B" + val;
            }

            if(findVecteur(val) != null){
                Vecteur v = findVecteur(val);
                if(v.getSens() == SensVecteur.GAUCHE){
                    if(v.getCouleur() == Couleur.ROUGE)
                        chaine += "<---r---";
                    else
                        chaine += "<---b---";
                }
                else {
                    if (v.getCouleur() == Couleur.ROUGE)
                        chaine += "---r--->";
                    else
                        chaine += "---b--->";
                }
            }
            else{
                chaine += "\n";
            }
        }
        return chaine;
    }
}
