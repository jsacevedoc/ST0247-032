/**
 * TALLER 5, BACKTRACKING, COLORING PROBLEM
 * @authors Jhonatan Acevedo Castrillón, Manuel Gutierrez Mejía
 */
import java.util.ArrayList;
public class Taller5 {
    /**
     * Método que dado un grafo y un número m, se asigna un color
     * a cada nodo, de manera que dos nodos adyacentes no posean el mismo color
     * @param grafazo grafo dado
     * @param m numero de colores
     * @return true si es posible, false de lo contrario
     */
    public static boolean mColoring(Digraph grafazo, int m) {

        int vertex=5; //Vértice dentro del grafo (elegido arbritáriamente)

        if (mColoring(grafazo, vertex, new int[grafazo.size], m)){
            System.out.println("Número de vértices del grafo: "+grafazo.size);
            return true;
        }
        return false;
    }
    /**
     * Método que dado un grafo y un vértice v, intenta asignar un color
     * al nodo, de manera que dos nodos adyacentes no posean el mismo color
     * @param grafazo grafo dado
     * @param m numero de colores
     * @param v vertice
     * @param colors conjunto de colores
     * @return true si es posible, false de lo contrario
     */
    private static boolean mColoring(Digraph grafazo, int v, int[] colors, int m) {

        if (grafazo.size == v){
            return true;
        }
        for (int painting = 0 ; painting < m ; painting++) {
            if (isSafe(grafazo, v, colors,painting)) {
                colors[v] = painting;
                if (mColoring(grafazo, v+1, colors, m)){
                    return true;
                }

                colors[v] = 0;
            }
        }

        return false;
    }
    /**
     * Método que dado un grafo y un vértice v, intenta asignar un color colors en la
     * posición c al nodo v, de manera que dos nodos adyacentes no posean el mismo color
     * @param grafazo grafo dado
     * @param c indice de colores
     * @param v vertice
     * @param colors conjunto de colores
     * @return true si es posible, false de lo contrario
     */
    private static boolean isSafe(Digraph grafazo, int v, int[] colors, int c) {

        ArrayList<Integer> Vsuccessors;
        Vsuccessors = grafazo.getSuccessors(v);

        for (Integer successor  : Vsuccessors){
            if (colors[successor] == c){
                return false;
            }
        }

        return true;
    }
}