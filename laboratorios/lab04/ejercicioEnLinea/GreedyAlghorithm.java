package colores;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author manuelgutierrez
 */
public class GreedyAlghorithm {

    public static void greedyRute(int n, int d, int r,
            LinkedList<Integer> rutasMañana, LinkedList<Integer> rutasTarde) {
        int dAux = 0;
        int restante = 0;
        for (int i = 0; i < rutasMañana.size(); i++) {
            if (dAux != 0) {
                dAux = Math.abs(dAux - rutasMañana.get(i));
            }

        }
        restante = Math.abs(dAux);
        dAux = d;
        for (int i = 0; i < rutasTarde.size(); i++) {
            if (dAux != 0) {
                System.out.println(dAux - rutasTarde.get(i));
                dAux = Math.abs(dAux - rutasTarde.get(i));
            }

        }
        restante += Math.abs(dAux);
        restante = restante * r;
        System.out.println(restante);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            int n = teclado.nextInt();
            int d = teclado.nextInt();
            int r = teclado.nextInt();
            LinkedList<Integer> rutasMañana = new LinkedList();
            for (int i = 0; i < n; i++) {
                rutasMañana.add(teclado.nextInt());
            }
            LinkedList<Integer> rutasTarde = new LinkedList();
            for (int i = 0; i < n; i++) {
                rutasTarde.add(teclado.nextInt());
            }
            Collections.sort(rutasMañana, Collections.reverseOrder());
            Collections.sort(rutasTarde, Collections.reverseOrder());
            greedyRute(n, d, r, rutasMañana, rutasTarde);
            n = teclado.nextInt();
            d = teclado.nextInt();
            r = teclado.nextInt();
            if (teclado.nextLine() == "0 0 0") {
                break;
            }
        }
    }
}
