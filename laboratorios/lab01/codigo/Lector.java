
package laboratorio01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class Lector {
   
    public static void main(String[] args) throws IOException {
   
        try {
            HashMap<Long, LinkedList<Pair<Long, Double>>> map = new HashMap();                      
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Castrillon\\Desktop\\lab\\medellin_colombia-grande.txt")); 
            String linea = br.readLine();
            
            
            while(linea != null && !linea.contains("Arcos")){
                 linea = br.readLine();               
                 if(!linea.isEmpty() && !linea.contains("Arcos")) {
                    String[] coord = linea.split(" ");
                    Vertices nuevoVert = new Vertices(Long.parseLong(coord[0]), Double.parseDouble(coord[1]), Double.parseDouble(coord[2]));
                    LinkedList<Pair<Long, Double>> listica = new LinkedList<>();
                    map.put(nuevoVert.id,  listica);
                }           
            }
                          
            linea = br.readLine(); 
                      
            while(linea != null){                  
                if(!linea.isEmpty()){              
                    String[] coord = linea.split(" ");
                    if(coord.length>3){
                       Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]), Double.parseDouble(coord[2]), coord[3]);
                       Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                       map.get(nuevoArc.idpart).add(pairsito);
                   }else{
                       Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]), Double.parseDouble(coord[2]), "descononcido");
                       Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                       map.get(nuevoArc.idpart).add(pairsito);
                   }
                    linea = br.readLine(); 
                }           
            }
            System.out.println(map.size());
            System.out.println("proceso terminado");             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
}
