package taller3;

/**
 *
 * @author Manuel Gutierrez, Jhonatan Acevedo
 */

 
public class taller3v2 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        nReinasAux(8);
        
    }
    
    private static boolean nReinas(int n, int [ ] tablero, int c){
        if (c >= n ){
            imprimirTablero(tablero);
            return true;          
        }   
        for(int r = 0; r < n; r++){
            tablero[c] = r;  
            if(seAtacanHastaElIoNo(tablero, c)){
              imprimirTablero(tablero);
              if(nReinas(n, tablero, c+1) == true){
                return true;
              }
             }
          }
       return false;
    }   
    
    public static void nReinasAux(int n){
    nReinas(n, new int[n], 0); 
    }
    
    private static boolean seAtacanHastaElIoNo(int [ ] tablero, int elI){
        for(int i = 0; i <= elI-1; i++){
            for(int j = i+1; j <= elI; j++){
                if((Math.abs(tablero[i]-tablero[j])==Math.abs(i-j))||(tablero[i]==tablero[j])){
                    return false;
                }
            }
        }
        return true;
    }

 public static void imprimirTablero(int[] tablero) {
    int n = tablero.length;
    System.out.print("    ");
    for (int i = 0; i < n; ++i)
       System.out.print(i + " ");
       System.out.println("\n");
    for (int i = 0; i < n; ++i) {
    System.out.print(i + "   ");
	for (int j = 0; j < n; ++j)
	    System.out.print((tablero[i] == j ? "Q" : "#") + " ");
	    System.out.println();
	}
    System.out.println();
  }
    
}
