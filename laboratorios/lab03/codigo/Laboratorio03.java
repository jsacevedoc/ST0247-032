import java.util.ArrayList;
import java.util.Arrays;
/**
 * Lab 03, 1.1 RUTA MAS CORTA DADOS DOS PUNTOS; A Y B
 * @authors Jhonatan Acevedo, Manuel Gutierrez
 */
public class Laboratorio03 {

    static DigraphAL grafazo = new DigraphAL(6);
    static int [] pesos = new int[grafazo.size()];

    public static void main(String[] args) {
        Arrays.fill(pesos,Integer.MAX_VALUE);
        grafazo.addArc(0,2,5);
        grafazo.addArc(0,1,1);
        grafazo.addArc(2,3,3);
        grafazo.addArc(1,2,3);
        grafazo.addArc(1,4,5);
        grafazo.addArc(2,4,1);
        grafazo.addArc(4,5,2);
        grafazo.addArc(3,5,1);
        rutaCortaBacktracking(grafazo, 0, 5);
    }

    public static void rutaCortaBacktracking (Digraph grafito, int a ,int b){
        pesos[a] = 0;
        rutaCortaBacktrackingaux(grafito, pesos, a);
        System.out.print("Arreglo de los pesos del camino elegido: ");
        System.out.print(Arrays.toString(pesos));
    }

    public static void rutaCortaBacktrackingaux (Digraph grafito, int []pesos, int a){
        ArrayList<Integer> sucesores = grafito.getSuccessors(a);
        if(grafito.getSuccessors(a) != null){
            for (Integer succ : sucesores){
                int peso = grafito.getWeight(a, succ) + pesos[a];
                if (pesos[succ] > peso){
                    pesos[succ] = peso;
                    rutaCortaBacktrackingaux(grafito, pesos, succ);
                }
            }
        }
    }
}