package taller03;

/**
 *
 * @author cl18417
 */
public class Taller03 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private static boolean nReinas(int n, int [ ] tablero, int c){
    
        if (c == n){
            imprimirTablero(tablero);
            return true;
        }       
        else{
            for(int r = 0; r < n; r++){
                
                tablero[c] = r;
                
                
            
                if(!seAtacanHastaElIoNo(tablero, r)){
                    
                }
                else{
                    
                }
                 
                if(!seAtacanHastaElIoNo(tablero, c)){
                    return false;
                }
                else{
                    nReinas(n, tablero, c+1);       
                }
            }
         }
     
          
    }
    
    public static void nReinasAux(int n){
    
    nReinas(n, new int[n], 0);
    
    }
    
    private static boolean seAtacanHastaElIoNo(int [ ] tablero, int elI){
        for(int i = 0; i < elI-1; i++){
            for(int j = i+1; j < elI; j++){
                return false;
            }
        }
        return true;
        
        




    }

    private static void imprimirTablero(int[] tablero) {
       
    }
    
}
