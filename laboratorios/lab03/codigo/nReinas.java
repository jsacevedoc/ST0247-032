/**
 *
 * @author manuelgutierrez and Jhonatan Acevedo Castrillón
 */
public class nReinas {
    public static void main(String[] args) {
        nReinasAux(8);
    }
    public static void nReinasAux(int n) {
        nReinas(0,new int[n]);
    }

    public static boolean nReinas(int j, int[] arrayReinas) {
        if (j > arrayReinas.length-1) {
            imprimirTablero(arrayReinas);
            return true;
        }
        arrayReinas[j] = -1;
        for (int i = 0; i < arrayReinas.length; i++) {
            arrayReinas[j] += 1;
            if (comprobarTablero(arrayReinas, j)) {
                if (j != arrayReinas.length) {
                    if(nReinas(j+1, arrayReinas) == true){
                        return true;
                    }              
                }
            }
        }
        return false;
    }

    public static boolean comprobarTablero(int[] tablero, int k) {
        for(int i = 0; i <= k-1; i++){
            for(int j = i+1; j <= k; j++){
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
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
 }
