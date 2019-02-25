/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

/**
 *
 * @author manuelgutierrez, Jhonatan Acevedo Castrillón
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class Lector {
   
    public static void main(String[] args) throws IOException {
        
         long TInicio, TFin, tiempo; 
         TInicio = System.currentTimeMillis(); 
    
        try {
            HashMap<Long, LinkedList<Pair<Long, Double>>> map = new HashMap();
            BufferedReader br = new BufferedReader(new FileReader
                                        ("/Users/manuelgutierrez/Laboratorio2/src/laboratorio2/medellin_colombia-pequeno.txt"));


            String linea = br.readLine();
            
            
            while(linea != null && !linea.contains("Arcos")){
                 linea = br.readLine();

                 if(!linea.isEmpty() && !linea.contains("Arcos")) {
                    String[] coord = linea.split(" ");


                    Vertices nuevoVert = new Vertices(Long.parseLong(coord[0]), Double.parseDouble(coord[1]),
                                                        Double.parseDouble(coord[2]));
     

                    LinkedList<Pair<Long, Double>> listica = new LinkedList<>();
                    map.put(nuevoVert.id,  listica);


                    
                }           
            }
                          
            linea = br.readLine(); 
        
                      
            while(linea != null){                  
                if(!linea.isEmpty()){              
                    String[] coord = linea.split(" ");
                    if(coord.length==4){
                                                    //id part, id llegada, distancia y nombre
                       Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]),
                                                    Double.parseDouble(coord[2]), coord[3]);

                       Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                       map.get(nuevoArc.idpart).add(pairsito);

                    }
                    else if(coord.length>4){

                            Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]),
                                    Double.parseDouble(coord[2]), coord[3]+" "+coord[4]);

                            Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                            map.get(nuevoArc.idpart).add(pairsito);

                    } else{

                       Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]),
                                                    Double.parseDouble(coord[2]), "descononcido");
                       Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                       map.get(nuevoArc.idpart).add(pairsito);
                   }
                    linea = br.readLine(); 
                }           
            }


            System.out.println("Camino con menor peso " +recorridoHamiltoMinim(map));
            System.out.println("proceso terminado");             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
         TFin = System.currentTimeMillis(); 
         tiempo = TFin - TInicio; 
         System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        
    }

    public static double recorridoHamiltoMinim(Map mapita){

        Long key;
        
        LinkedList<Pair<Long,Double>> value;

        double contador = 0;
        
        ArrayList<Long> visitados = new ArrayList();
        
        ArrayList<Double> pesoCaminos = new ArrayList();
        
        Iterator entries = mapita.entrySet().iterator();
        
        
        Long keyAux = (Long) mapita.get(entries);
                
        boolean nuevoComienzo = false;
        

        
        while (entries.hasNext()) { 

            if(nuevoComienzo == false){
            Map.Entry entry = (Map.Entry) entries.next(); // nuevo mapa
            key = (Long)entry.getKey(); //Obtenemos la llave
            value = (LinkedList) entry.getValue(); //Obtenemos valor
            }
            else{
                key = keyAux;
                value = (LinkedList)mapita.get(key);
            }
                       
            for(int i = 0; i < value.size();i++){
                if(visitados.contains(value.get(i).getKey())){
                    

                }
                else{
                    visitados.add(value.get(i).getKey());
                    contador += value.get(i).getValue();
                    keyAux = value.get(i).getKey();
                    nuevoComienzo = true;
                    break;
                }               
            }

            if(visitados.size() == mapita.size()){
                pesoCaminos.add(contador);
                contador = 0;
                visitados.clear();
                nuevoComienzo = false;
            }            
        }
        pesoCaminos.sort(null);
        return pesoCaminos.get(0);
    }
}
