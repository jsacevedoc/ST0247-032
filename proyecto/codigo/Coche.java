package laboratorio01;

import java.util.LinkedList;

public class Coche {
    LinkedList<Integer> personasEnCoche = new LinkedList<>();
    public void addPersonasCoche(int idVertice){
        personasEnCoche.add(idVertice);
    }
}
