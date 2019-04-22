import java.util.ArrayList;
import java.util.List;
/**
 * Lab 04, 1, IMPLEMENTACIÓN DEL PROBLEMA DEL AGENTE VIAJERO CON ALGORITMO VORÁZ
 * @authors Jhonatan Acevedo, Manuel Gutierrez
 */
public class Laboratorio04 {

    public static void main(String[] args) {
        DigraphAL g3 = new DigraphAL(4);
        g3.addArc(0, 0, 0);
        g3.addArc(0, 1, 7);
        g3.addArc(0, 2, 15);
        g3.addArc(0, 3, 6);
        g3.addArc(1, 0, 2);
        g3.addArc(1, 1, 0);
        g3.addArc(1, 2, 7);
        g3.addArc(1, 3, 3);
        g3.addArc(2, 0, 9);
        g3.addArc(2, 1, 6);
        g3.addArc(2, 2, 0);
        g3.addArc(2, 3, 12);
        g3.addArc(3, 0, 10);
        g3.addArc(3, 1, 4);
        g3.addArc(3, 2, 8);
        g3.addArc(3, 3, 0);

        DigraphAL g2 = new DigraphAL(4);
        g2.addArc(0, 2, 15);
        g2.addArc(2, 0, 15);
        g2.addArc(0, 3, 20);
        g2.addArc(3, 0, 20);
        g2.addArc(0, 1, 10);
        g2.addArc(1, 0, 10);
        g2.addArc(3, 1, 25);
        g2.addArc(1, 3, 25);
        g2.addArc(3, 2, 30);
        g2.addArc(2, 3, 30);
        g2.addArc(1, 2, 35);
        g2.addArc(2, 1, 35);
        g2.addArc(0, 0, 0);
        g2.addArc(1, 1, 0);
        g2.addArc(2, 2, 0);
        g2.addArc(3, 3, 0);

        DigraphAL g1 = new DigraphAL(5);
        g1.addArc(0, 0, 0);
        g1.addArc(0, 1, 2);
        g1.addArc(0, 2, 2);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 4);
        g1.addArc(1, 1, 0);
        g1.addArc(1, 0, 2);
        g1.addArc(1, 2, 3);
        g1.addArc(1, 3, 2);
        g1.addArc(1, 4, 3);
        g1.addArc(2, 2, 0);
        g1.addArc(2, 0, 2);
        g1.addArc(2, 1, 3);
        g1.addArc(2, 3, 2);
        g1.addArc(2, 4, 2);
        g1.addArc(3, 3, 0);
        g1.addArc(3, 0, 1);
        g1.addArc(3, 1, 2);
        g1.addArc(3, 2, 2);
        g1.addArc(3, 4, 4);
        g1.addArc(4, 4, 0);
        g1.addArc(4, 0, 4);
        g1.addArc(4, 1, 3);
        g1.addArc(4, 2, 2);
        g1.addArc(4, 3, 4);

        agenteViajeroVorazAux(g1);

    }

    public static ArrayList<Integer> agenteViajeroVorazAux(DigraphAL g){
        List<Integer> ciudades = g.getSuccessors(0);
        Boolean visitados[] = new Boolean[ciudades.size()];
        for(int i=0; i<visitados.length; i++){
            visitados[i] = false;
        }
        int ciudadInicio = 0;
        ArrayList<Integer> ruta = new ArrayList<>();
        return agenteViajeroVoraz(ciudadInicio, ciudades, g, ruta, visitados);
    }

    public static ArrayList<Integer> agenteViajeroVoraz(int ciudadInicio, List<Integer> ciudades, Digraph g,
                                                        ArrayList<Integer> ruta, Boolean visitados[]){
        int minCost;
        int currentIndex;
        int tempCost;
        int ciudadActual = ciudadInicio;
        int costoRuta = 0;
        ruta.add(ciudades.get(ciudadInicio));
        visitados[ciudadInicio] = true;
        Integer sigCiudad = null;

        for(int i = 1; i < ciudades.size(); i++){
            minCost = Integer.MAX_VALUE;
            currentIndex = -1;
            for (int  j= 0;  j< ciudades.size(); j++) {
                if (!visitados[j]) {
                    tempCost = g.getWeight(ciudadActual, ciudades.get(j));
                    if (tempCost < minCost) {
                        minCost = tempCost;
                        sigCiudad = ciudades.get(j);
                        currentIndex = j;
                        costoRuta += minCost;
                    }
                }
            }
            if (minCost == Integer.MAX_VALUE) {
                break;
            } else {
                ruta.add(sigCiudad);
                visitados[currentIndex] = true;
                ciudadActual = sigCiudad;
            }
        }
        ruta.add(ciudades.get(ciudadInicio));
        System.out.println("Ruta: "+ruta.toString());
        System.out.println("Costo ruta: "+costoRuta);
        return ruta;
    }
}


