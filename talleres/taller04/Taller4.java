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
    
    public static int hamiltonCostMinCamino(Digraph g, int o){
        //declaración de variables 
        int[] cost = new int[1];
        int vert = 0;
        boolean[] visit =new boolean[g.size()];
        int size = 0;
        cost[0] = 99999;   
        hamiltonCostMinAux(g, o, o, visit, cost, size, vert);
        return cost[0] == Integer.MAX_VALUE ? 0 : cost[o];
        
    }
    
    public static boolean hamiltonCostMinAux(Digraph g, int o, int d, boolean[] visitados,int[] peso, int size
            , int vert){
        
        ArrayList<Integer> hijazos = g.getSuccessors(o);
  
        //Condición de parada si el origen es igual al destino y hemos recorrido todos los vértices
        if(o == d && g.size() == vert){
            if(size < peso[0]){
                peso[0]=size;
            }
            visitados[o] = false;
            return true;
        }               
         vert=vert+1;     
         visitados[o]=true;
         // ciclo recorriendo los hijos
        for (Integer hijito:hijazos) {
            if(( !visitados[hijito]    &&    size+g.getWeight(o, hijito)<peso[0])    ||    (hijito == d     &&    vert == g.size())){
                size += g.getWeight(o,    hijito);
                //nuevo llamado recursivo, esta vez tomando como origen el hijo
                hamiltonCostMinAux(g,  hijito,  d, visitados,    peso,   size,    vert);
                
                
            }
            
        }
        visitados[o]=false;
        return false;
        
    }




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
        hamiltonCostMinCamino(grafito, 1);
    }
    
}
