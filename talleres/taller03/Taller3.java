package taller3;

import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 2
 * 
 * @author Mauricio Toro, Camilo Paez
 */
public class Taller2 {

public static void permutaciones(String cadena){
   permutacionesAux("",cadena);
   //conjuntoPotenciaAux("",cadena);
}

private static void permutacionesAux(String loqueyallevo, String loquemefalta){

    // caso base
    if(loquemefalta.isEmpty()){
        System.out.println(loqueyallevo);
        System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(loqueyallevo));
    }
    else{
        for(int i = 0; i < loquemefalta.length();i++){
            permutacionesAux(loqueyallevo+loquemefalta.charAt(i),loquemefalta.substring(0,i)+loquemefalta.substring(i+1));
        }
    }
    
    
    
    
    
    // caso o casos recursivos
}

public static void conjuntoPotencia(String cadena){
   conjuntoPotenciaAux("",cadena);
}


private static void conjuntoPotenciaAux(String loqueyallevo, String loquemefalta){
  
    if (loquemefalta.isEmpty()) 
          System.out.println(loqueyallevo);
    else{
          conjuntoPotenciaAux(loqueyallevo,loquemefalta.substring(1));
          conjuntoPotenciaAux(loqueyallevo+loquemefalta.charAt(0),loquemefalta.substring(1));
        }
}
    public static void main(String[] args) {
        permutaciones("abcd");
    }
}
