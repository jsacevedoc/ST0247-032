package taller4;

import java.util.ArrayList;

/**
 *
 * @author manuelgutierrez
 */
public class Taller4 {
    
    public static boolean hayCamino(Digraph g, int o, int d){
       boolean [] visitados = new boolean[g.size()];    
       return hayCaminoAux(g, o, d, visitados);
    }
     public static int costoMinimo(Digraph g, int o, int d){
       boolean [] visitados = new boolean[g.size()];    
       return costoMinimoAux(g, o, d, visitados);
    }

    public static boolean hayCaminoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        if (o == d){
           return true;
        }
        else {
           ArrayList<Integer> hijos = g.getSuccessors(o);          
              for (Integer hijo: hijos)
                if (!visitados[hijo] && hayCaminoAux(g, hijo, d, visitados)) return true;
                    return false;

             }      

        }

    public static int costoMinimoAux(Digraph g, int o, int d, boolean[] visitados) { 
        visitados[o] = true;
        int costoCamino = 0;
        int costoCaminoAux = Integer.MAX_VALUE;
        if (o == d){

           return costoCamino;
        }
        else {
           ArrayList<Integer> hijos = g.getSuccessors(o);          
                for (Integer hijo: hijos){
                    if (!visitados[hijo]){
                        boolean [] arregloAux =  new boolean[g.size()]; 
                       costoCamino = costoMinimoAux(g, hijo, d,arregloAux)+ g.getWeight(o, hijo);
                       if(costoCamino<=costoCaminoAux){
                           costoCaminoAux = costoCamino;
                           System.out.println(costoCamino);
                       }
                    }
             } 
            return costoCaminoAux;
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DigraphAL grafito = new DigraphAL(8);
        grafito.addArc(0, 1, 2);
        grafito.addArc(0, 3, 3);
        grafito.addArc(0, 5, 1);
        grafito.addArc(1, 2, 9);
        grafito.addArc(2, 7, 10);
        grafito.addArc(3,4,3);
        grafito.addArc(4, 7, 12);
        grafito.addArc(0,5,1);
        grafito.addArc(5,4,2);
        grafito.addArc(5,6,20);
        grafito.addArc(6, 7, 2);
        System.out.println(costoMinimo(grafito,0,7));
    }
    
}



