package solution;

import graphe.ClasseInstance;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static void main(String[] args) {
        List<Double> listOfAverage = new ArrayList<>();

        for (float i = 0; i < 1.1; i+=0.1) {
            System.out.println("i = "+i);
            for (float j = 0; j <=1.1 ; j+=0.1) {
                System.out.println("j = "+j);
                int l=0;
                for (int k = 0; k < 100; k++) {
                    ClasseInstance.instaceGraphe(i,j);
                    RougeBleu.reset();

                    RougeBleu.resolve();

                    l+=RougeBleu.getNumber();
                    ClasseInstance.reset();
                }
                listOfAverage.add((double) l/100);
            }
        }
        System.out.println(listOfAverage);
    }
}
