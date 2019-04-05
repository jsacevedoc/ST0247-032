
package laboratorio01;


public class Vertices {
    
    long id;
    double coordx;
    double coordy;
    String nombre;

    public Vertices(long id, double coordx, double coordy, String nombre) {
        this.id = id;
        this.coordx = coordx;
        this.coordy = coordy;
        this.nombre = nombre;
    }

    public long getId(){
        return this.id;
    }

    public double getCoordx(){
        return this.coordx;
    }

    public double getCoordy(){
        return this.coordy;
    }

    public String getNombre(){return  this.nombre;}

}
