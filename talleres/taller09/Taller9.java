import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author cl18417
 */
// esto es un hijueputa codigazo pero vamos hasta la chimba joder puchujensoooooo

public class Recursion {
    public static int[] factorial(int n){
        int[] factores = new int [n+1];
        factores[0] = 1;
        factores[1]=1;
        for(int i = 2; i <= n ; i++){
            factores[i] = i*factores[i-1];
        }
        return factores;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(factorial(6)));
        System.out.println("factobasic  "+factobasic(6));
        
        
        System.out.println("ACA EMPEZO EL VIEJO LEVEN");
        
        System.out.println(viejoLeven("horse","ros"));
    }
    
    public static int factobasic(int n){
        int aux=1;
        for(int i = 1; i <= n; i++){
           aux = aux*i;
        }
        return aux;
    }
    public static int viejoLeven(String s1, String s2){
        int[][] matrizPeneceal = new int[s1.length()+1][s2.length()+1];
        for(int i = 1; i <= s1.length(); i++){
            matrizPeneceal[i][0] = i;;
        }
        for(int i = 1; i <= s2.length(); i++){
           matrizPeneceal[0][i] = i;
        }
        
        for(int j = 1;j <= s2.length(); j++){
            for(int i = 1; i <= s1.length(); i++){
                            System.out.println(Arrays.toString(matrizPeneceal[j]));
                if(s2.charAt(j-1)== s1.charAt(i-1)){
                    matrizPeneceal[i][j] = matrizPeneceal[i-1][j-1];
                    
                }
                else{
                   matrizPeneceal[i][j] = Math.min(Math.min((matrizPeneceal[i-1][j])+1, (matrizPeneceal[i][j-1])+1),
                           (matrizPeneceal[i-1][j-1])+1);
                }
             }
        }
                return matrizPeneceal[s1.length()-1][s2.length()-1];
    }
