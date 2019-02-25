
/**
 * @authors Jhonatan Acevedo Castrillón, Manuel Gutierrez Mejía
 */

import java.util.LinkedList;
import java.util.Scanner;

public class EjercicioEnLinea {

    public static void main(String[] args) {
        lector();

    }

    public static void lector(){

        LinkedList<Integer> answ = new LinkedList<>();
        int j=0;
        Scanner scan;
        scan = new Scanner(System.in);

        int aux = scan.nextInt();


        int contador;
        contador=0;

        while(contador < 2 || aux != 0){
            int[][] plantilla = lectorAux(aux);
            answ.add(Reinas(aux, plantilla));
            aux = scan.nextInt();
            contador++;
        }

        for(Integer i : answ){
            System.out.println("Case " + j + ": " + i);
            ++j;
        }
    }

    private static int[][] lectorAux(int Reinas){
        Scanner scan;
        scan = new Scanner(System.in);
        int[][] plantilla = new int[Reinas][Reinas];
        int i = 0;
        while (i < Reinas) {
            String fila = scan.nextLine();
            for(int j = 0; j < fila.length(); j++){
                if(fila.charAt(j) == '*'){
                    plantilla[i][j] = -1 ;
                }
            }
            i++;
        }
        return plantilla;
    }

    public static int Reinas(int cantreinas, int[][] plantilla){
        int[] place = new int[cantreinas];
        int[] acom = new int[1];
        final int i = ReinasAux(cantreinas, plantilla, 0, place, acom);
        return i;
    }

    private static int ReinasAux(int cantreinas, int[][] plantilla, int col, int[] place,int[] acom){
        if(col>= cantreinas && conflicto(place,cantreinas)) acom[0] += 1;
        if (col >= cantreinas) {
            return acom[0];
        }
        for(int f = 0; f < cantreinas; f++){
            if(plantilla[f][col] != -1){
                place[col] = f;
                ReinasAux(cantreinas,plantilla, col+1, place, acom);
            }
        }
        return acom[0];
    }


    private static boolean conflicto(int [ ] plantilla, int index){
        for(int i = 0; i <= index-1; i++)
            for (int j = i + 1; j < index; j++)
                if ((Math.abs(i - j) == Math.abs(plantilla[i] - plantilla[j])) || (plantilla[i] == plantilla[j])) {
                    final boolean b = false;
                    return b;
                }
        return true;
    }


}
