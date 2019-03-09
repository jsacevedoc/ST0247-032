/**
 * TALLER 7
 * @authors Jhonatan Acevedo Castrillón, Manuel Gutierrez Mejía
 */
import java.util.*;

public class Taller7 {

    public int elMasPequenoNoVisitado(Digraph g, boolean[] visitados, int[] tabla){
        //HECHO POR LA COMPAÑERA MARIA SOFÍA EN CLASE
        int menorAux = Integer.MAX_VALUE;
        int aux = -1;
        for(int i = 0; i < tabla.length; i++){
            if(!visitados[i] && tabla[i] < menorAux){
                menorAux = tabla[i];
                aux = i;
            }
        }
        return aux;
    }

    public void actualizarLosPesosDeLaTablaConElValorActual(Digraph g, int actual, int[] tabla){
        //HECHO POR EL COMPAÑERO ALEJANDRO EN CLASE
        for(int destino: g.getSuccessors(actual)){
            if(tabla[destino] != Integer.MAX_VALUE){
                tabla[destino] += g.getWeight(actual, destino);
            }
            else{
                tabla[destino] = g.getWeight(actual,destino);
            }
        }
    }

    public int[] llenarUnArregloConInfinitos(int n, int v){
        int[] a = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[v] = 0;
        return a;
    }

    public boolean[] llenarUnArregloConFalsos(int n){
        boolean[] a = new boolean[n];
        Arrays.fill(a, false);
        return a;
    }

    public int[] dijkstra(Digraph g, int v){

        int[] tabla = llenarUnArregloConInfinitos(g.size(),v);
        int actual = v;
        boolean[] visitados = new boolean[g.size()];
        for (int i = 0; i < g.size(); i++) {
            actual = elMasPequenoNoVisitado(g, visitados, tabla);
            visitados[actual] = true;
            actualizarLosPesosDeLaTablaConElValorActual(g, actual, tabla);
        }
        return tabla;

    }

    public int primMST(Digraph grafito) {

        int iterafather[] = new int[grafito.size];
        iterafather[0] = -1;
        boolean visitados[] = llenarUnArregloConFalsos(grafito.size());
        int x[] = llenarUnArregloConInfinitos(grafito.size,0);
        int respuestarecorrido = 0;


        for (int i=0; i <grafito.size-1; i++) {
            int vaux = elMasPequenoNoVisitado(grafito,visitados,x);
            visitados[vaux] = true;
            for (Integer succ : grafito.getSuccessors(vaux)){
                int pesoadya = grafito.getWeight(vaux,succ);
                if (pesoadya == 0 || visitados[succ] || pesoadya >= x[succ]) {
                } else {
                    iterafather[succ] = vaux;
                    x[succ] = pesoadya;
                }
            }
        }
        for (int i = 1; i < grafito.size; i++){
            respuestarecorrido += grafito.getWeight(i,iterafather[i]);
        }
        return respuestarecorrido;
    }
}