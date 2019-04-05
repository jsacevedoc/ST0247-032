
package laboratorio01;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class Lector {

    static HashMap<Long, LinkedList<Pair<Long, Double>>> map = new HashMap();
    static HashMap<Integer,LinkedList<Coche>> mapaCoches = new HashMap<Integer, LinkedList<Coche>>();

    public static void main(String[] args) throws IOException {
        leerArchivo("C:\\Users\\Castrillon\\Documents\\JavaProjects\\" +
                "LABORATORIO01\\test\\dataset-ejemplo-U=205-p=1.3.txt"
        );
        ArrayList<String> arraysito;
        arraysito = new ArrayList();

        String contador = "";

        for (Map.Entry<Integer, LinkedList<Coche>> mapet : mapaCoches.entrySet()) {
            for (Coche coche : mapet.getValue()) {
                for (Integer i : coche.personasEnCoche) {
                    System.out.print(i + " ");
                    contador +=  i.toString()+" ";
                }
                arraysito.add(contador.toString());
                contador = "";
                System.out.println("tamaño: " + coche.personasEnCoche.size());
            }
            System.out.println("tamaño carro: " + mapet.getValue().size());
        }

        escritor(arraysito, contador);



    }

    public static void leerArchivo(String filename) throws IOException{

        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();

        try {

            BufferedReader br = new BufferedReader(new FileReader
                    (filename));

            String linea = br.readLine();

            while(linea != null && !linea.contains("Costo")){

                linea = br.readLine();


                if(!linea.isEmpty() && !linea.contains("Costo")) {
                    String[] coord = linea.split(" ");

                    if(coord.length == 3){

                        Vertices nuevoVert = new Vertices(Long.parseLong(coord[0]), Double.parseDouble(coord[1]),
                                Double.parseDouble(coord[2]), "Sin nombre");
                        LinkedList<Pair<Long, Double>> listica = new LinkedList<>();


                        map.put(nuevoVert.id,  listica);
                        maxCarritostoUniversidad(nuevoVert);


                    }
                    else if(coord.length == 4){
                        Vertices nuevoVert = new Vertices(Long.parseLong(coord[0]), Double.parseDouble(coord[1]),
                                Double.parseDouble(coord[2]), coord[3]);
                        LinkedList<Pair<Long, Double>> listica = new LinkedList<>();
                        map.put(nuevoVert.id,  listica);
                        maxCarritostoUniversidad(nuevoVert);
                    }
                    else{
                        Vertices nuevoVert = new Vertices(Long.parseLong(coord[0]), Double.parseDouble(coord[1]),
                                Double.parseDouble(coord[2]), coord[3]+" "+coord[4]);
                        LinkedList<Pair<Long, Double>> listica = new LinkedList<>();
                        map.put(nuevoVert.id,  listica);
                        maxCarritostoUniversidad(nuevoVert);
                    }
                }
            }

            linea = br.readLine();


            while(linea != null){

                if(!linea.isEmpty()){
                    String[] coord = linea.split(" ");

                    if(coord.length == 4){
                        System.out.println("hola");
                        //id part, id llegada, distancia y nombre
                        Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]),
                                Double.parseDouble(coord[2]), coord[3]
                        );

                        Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                        map.get(nuevoArc.idpart).add(pairsito);

                    }
                    else if(coord.length > 4){
                        //id part, id llegada, distancia y nombre
                        Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]),
                                Double.parseDouble(coord[2]), coord[3]+" "+coord[4]
                        );

                        Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                        map.get(nuevoArc.idpart).add(pairsito);

                    } else{

                        Arcos nuevoArc = new Arcos(Long.parseLong(coord[0]), Long.parseLong(coord[1]),
                                Double.parseDouble(coord[2]), "Sin nombre"
                        );

                        Pair pairsito = new Pair(nuevoArc.idlleg, nuevoArc.distancia);
                        map.get(nuevoArc.idpart).add(pairsito);



                    }

                    linea = br.readLine();

                }
            }

            System.out.println("Tamaño del hashmap: "+map.size());

            long x = 58;

            System.out.println("----------------PROCESO TERMINADO----------------");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }

        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);

    }

    public static void maxCarritostoUniversidad(Vertices verticesito){

        //(x*x)/(y/2)
        int x = (int)(verticesito.getCoordx() * 100);
        x = Math.abs(x%100);
        int y = (int)(verticesito.getCoordy() * 100);
        y = Math.abs(y%100);
        System.out.println(x);
        System.out.println(y);
        System.out.println("id: " + verticesito.id );
        System.out.println("x+y: " + (x+y));
        if(mapaCoches.get(x+y) == null) {
            LinkedList<Coche> coches = new LinkedList();
            mapaCoches.put(x+y,coches);
            Coche cochesito = new Coche();
            mapaCoches.get(x+y).add(cochesito);
        }
        boolean agregado = false;
        for(Coche c : mapaCoches.get(x+y)) {
            if (c.personasEnCoche.size() < 5) {
                c.addPersonasCoche((int) verticesito.getId());
                agregado = true;
                break;
            }
        }
        if(!agregado){
            Coche cochesito = new Coche();
            mapaCoches.get(x + y).add(cochesito);
            cochesito.addPersonasCoche((int)verticesito.getId());
        }

    }

    public static void escritor(ArrayList arraysito, String joan){

        BufferedWriter bw = null;
        FileWriter fw = null;
        int count = 0;
        try {
            int i = 0;
            fw = new FileWriter("C:\\Users\\Castrillon\\Documents\\JavaProjects\\" +
                    "LABORATORIO01\\test\\nuevoArchivo");
            bw = new BufferedWriter(fw);

            while (i < arraysito.size()) {
                bw.write(arraysito.get(i).toString()+" ");
                bw.newLine();
                System.out.println("i "+i);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }
}
