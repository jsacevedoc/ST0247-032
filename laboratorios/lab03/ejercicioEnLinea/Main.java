
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author manuelgutierrez and Jhonatan Acevedo Castrillón
 */
public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int vertices = teclado.nextInt();
        int arcos = teclado.nextInt();
        DigraphAL grafito = new DigraphAL(vertices); //Creamos el grafo 
        for (int i = 0; i < arcos; i++) {
            int origen = teclado.nextInt();
            int destino = teclado.nextInt();
            int peso = teclado.nextInt();
            grafito.addArc(origen, destino, peso);
            grafito.addArc(destino, origen, peso);
        }
        teclado.close();
        caminoMin(grafito);

    }

    public static LinkedList<Integer> caminoMin(DigraphAL g) {
        boolean[] visitados = new boolean[g.size()];
        LinkedList<Integer> respuesta = new LinkedList();
        LinkedList<Integer> respuestaF = new LinkedList();
        int[] sumaF = new int[1];
        sumaF[0] = Integer.MAX_VALUE;
        int suma = 0;
        boolean r = caminoMinAux(g, 0, visitados, respuesta, respuestaF, suma, sumaF, false);
        if (r) {
            System.out.print("respuesta: [ ");
            for (int i = 0; i < respuestaF.size() - 1; i++) {
                System.out.print(respuestaF.get(i) + ", ");
            }
            System.out.print(respuestaF.get(respuestaF.size() - 1));
            System.out.println(" ]");
            return respuestaF;
        } else {
            System.out.println("-1");
            LinkedList a = new LinkedList();
            return a;
        }
    }

    public static boolean caminoMinAux(DigraphAL g, int v, boolean[] visitados,
            LinkedList<Integer> respuesta, LinkedList<Integer> respuestaF,
            int suma, int[] sumaF, boolean r) {

        if (v == g.size() - 1) {
            respuesta.add(v);
            sumaF[0] = suma;
            respuestaF.clear();
            respuestaF.addAll(respuesta);
            respuesta.removeLast();
            r = true;
        }
        visitados[v] = true;
        respuesta.add(v);
        for (int hijos : g.getSuccessors(v)) {
            if (!visitados[hijos] && g.getWeight(v, hijos) + suma < sumaF[0]) {
                suma += g.getWeight(v, hijos);
                r = caminoMinAux(g, hijos, visitados, respuesta, respuestaF, suma, sumaF, r);
                suma -= g.getWeight(v, hijos);
                respuesta.removeLast();
            }
        }
        visitados[v] = false;
        return r;
    }

}
