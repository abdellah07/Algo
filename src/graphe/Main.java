package graphe;

import java.util.Scanner;

public class Main {


    public static void main (String[] args){
        ClasseInstance cI = new ClasseInstance(0.5, 0.5);

        System.out.println("Veuillez saisir le sommet à supprimer:");

        String ch;
        Scanner sc = new Scanner(System.in);

        while( (ch = sc.nextLine()) != ""){
            try{
                int index = Integer.parseInt(ch);
                cI.deleteSommet(index);
            }catch(Exception  e){
                System.out.println(ch+" n'est pas un entier");
            }
        }
    }
}
