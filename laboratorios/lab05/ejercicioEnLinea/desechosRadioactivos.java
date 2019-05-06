package colores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manuelgutierrez
 */
public class desechosRadioactivos {

    public static int buscar(String[][] matricia, Pair<Integer, Integer> coords) {
        int contador = 0;
        for (int i = 0; i < matricia.length; ++i) {
            for (int j = 0; j < matricia[0].length; ++j) {
                if (!matricia[i][j].equals("K") && !matricia[i][j].equals("R")) {
                    int value = Math.abs(i - coords.getKey()) + Math.abs(j - coords.getValue());
                    matricia[i][j] = Integer.toString(value);
                } else {
                    if (!matricia[i][j].equals("K")) {
                        matricia[i][j] = "V";
                        int value = 0;
                        Pair<Integer, Integer> coorRad = new Pair(i, j);
                        if ((!matricia[i + 1][j].equals("0") || !matricia[i - 1][j].equals("0") || !matricia[i][j + 1].equals("0") || !matricia[i][j - 1].equals("0"))
                                && (i > 0 && i < matricia.length - 1 && i > 0 && i < matricia.length - 1)) {
                            value = Math.min(Integer.parseInt(matricia[i][j - 1]), Math.min(Integer.parseInt(matricia[i + 1][j]),
                                    Math.min(Integer.parseInt(matricia[i - 1][j]), Integer.parseInt(matricia[i][j + 1])))) + 1;
                        }
                        return buscar(matricia, coorRad) + value;
                    } else {
                        if (contador > 0) {
                            return 0;
                        }
                        contador++;
                    }
                }
            }
            System.out.println();
        }
        return 0;
    }

    public static Pair<String[][], Pair<Integer, Integer>> lector() {

        BufferedReader lector = null;
        String FileName = "Archivo.txt";
        Pair<String[][], Pair<Integer, Integer>> answ = null;
        String[][] matriz = null;
        try {
            lector = new BufferedReader(new FileReader(FileName));
            int escenarios = Integer.parseInt(lector.readLine());
            while (escenarios > 0) {
                String line = lector.readLine();
                String[] dimensiones = line.split(" ");
                int dimX = Integer.parseInt(dimensiones[0]), dimY = Integer.parseInt(dimensiones[1]);
                matriz = new String[dimY][dimX];
                String linea2 = lector.readLine();
                String[] coorKaro = linea2.split(" ");
                int coorX = Character.getNumericValue(coorKaro[0].charAt(0)), coorY = Character.getNumericValue(coorKaro[1].charAt(0));
                matriz[coorY - 1][coorX - 1] = "K";
                int numDesRad = Integer.parseInt(lector.readLine());
                while (numDesRad > 0) {
                    String linea3 = lector.readLine();
                    String[] coorRad = linea3.split(" ");
                    int radX = Character.getNumericValue(coorRad[0].charAt(0)), radY = Character.getNumericValue(coorRad[1].charAt(0));
                    matriz[radY - 1][radX - 1] = "R";
                    --numDesRad;
                }
                Pair<Integer, Integer> coordenadas = new Pair(coorY - 1, coorX - 1);
                answ = new Pair(matriz, coordenadas);
                --escenarios;
            }
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] == null) {
                        matriz[i][j] = "0";
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return answ;
    }

    public static void main(String[] args) {
        Pair<String[][], Pair<Integer, Integer>> pair = lector();
        System.out.println("The shortest path has length." + buscar(pair.getKey(), pair.getValue()));

    }
}
