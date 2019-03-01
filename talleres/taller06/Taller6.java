/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Taller6 {
    /**
 *
 * @author Jhonatan Acevedo Castrillón, Manuel Gutierrez Mejía
 */

   public static int caminoGreedy(Digraph grafito, int o){
       boolean []visitados = new boolean[grafito.size()];
       return caminoGreedyAux(grafito,o,visitados,0,o);
   }
   public static int caminoGreedyAux(Digraph grafito, int o, boolean[] visitados, int tamGrafo, int d){
      int menorAux = Integer.MAX_VALUE;
      int menorGrafoAux=-1;
      visitados[o] = true;
      if(tamGrafo == visitados.length && o == d){
          return 0;
      }
      else{
          for(int grafo: grafito.getSuccessors(o)){
              
              if((grafito.getWeight(o, grafo) <= menorAux && visitados[grafo]==false) || 
                  grafo == d && tamGrafo == grafito.size()-1){
                  
                  menorAux = grafito.getWeight(o, grafo);
                  menorGrafoAux = grafo;  
                  
              }            
          }
          return menorAux + caminoGreedyAux(grafito,menorGrafoAux,visitados,tamGrafo+1,d);
      }
   }
    public static int[] cambioGreedy(int n, int[] denominaciones){
        int []respuesta = new int [denominaciones.length];
        for(int i = 0; i < denominaciones.length;i++){
            int cantidad= n / denominaciones[i];
            respuesta[i] = cantidad;
            n = n%denominaciones[i];
        }
        return respuesta;
    }    

    /**
     * @param args the command line arguments
     */
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
		if (caminoGreedy(g3,0) != 26){
                    System.out.println("falso");
                        
                }
                else{
		System.out.println("true");
                }
	}      
    }

