/**
 * Laboratorio 05
 * @authors Jhonatan Acevedo Castrillón, Manuel Gutierrez Mejía
 */

public class Lab05 {

    public static int heldKarpAux(Digraph grafito ,int pesoAcom[][], int antecesores[][], int vertIter, int binarySet) {
        int maskCond;
        int set;
        if (pesoAcom[vertIter][binarySet] == -1) {
            int defAux = -1;
            for (int i = 0; i < grafito.size(); i++) {
                maskCond = (int)Math.pow(2, grafito.size()) - (int) Math.pow(2, i)  - 1;
                set = binarySet & maskCond;
                if (set != binarySet) {
                    int temp = grafito.getWeight(vertIter,i) + heldKarpAux(grafito,pesoAcom,antecesores,i, set);
                    if (defAux == -1 || defAux > temp) {
                        defAux = temp;
                        antecesores[vertIter][binarySet] = i;
                    }
                }
            }
            pesoAcom[vertIter][binarySet] = defAux;
            return defAux;
        } else {
            final int i = pesoAcom[vertIter][binarySet];
            return i;
        }
    }

    public static int heldKarp(Digraph grafito) {
        int[][] pesoAcom;
        pesoAcom = new int[grafito.size][(int) Math.pow(2, grafito.size)];
        int[][] antecesores;
        antecesores = new int[grafito.size][(int) Math.pow(2, grafito.size)];

        int i = 0;
        while (i < grafito.size) {
            int j = 0;
            while (j < (int) Math.pow(2, grafito.size)) {
                antecesores[i][j] = -1;
                if (j ==0) {
                    pesoAcom[i][0] = grafito.getWeight(i,0);
                } else{ pesoAcom[i][j] = -1;}
                j++;
            }
            i++;
        }

        return heldKarpAux(grafito,pesoAcom,antecesores, 0, (int) Math.pow(2, grafito.size) - 2);
    }
}