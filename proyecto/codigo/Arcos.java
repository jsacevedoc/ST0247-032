
package laboratorio01;


public class Arcos {

    long idpart;
    long idlleg;
    double distancia;
    String nombre;
    
    public Arcos(long idpart, long idlleg, double distance, String name){
        this.idpart=idpart;
        this.idlleg=idlleg;
        this.distancia=distance;
        this.nombre=name;
        
    }

    public long getIdpart(){
        return this.idpart;
    }

    public long getIdlleg(){
        return this.idlleg;
    }

    public double getDistancia(){
        return this.distancia;
    }

    public String getNombre() {
        return this.nombre;
    }
}
