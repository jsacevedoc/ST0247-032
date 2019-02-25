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
public class Vertices {
    
    long id;
    double coordx;
    double coordy;
    public Vertices(long id, double coordx, double coordy) {
        this.id = id;
        this.coordx = coordx;
        this.coordy = coordy;
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

}
