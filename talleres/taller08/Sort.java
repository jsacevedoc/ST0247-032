package pruebas;

import java.util.Arrays;

/**
 *
 * @author manuelgutierrez
 */
public class Sort {
    
    public static int[] mergeSort(int[] arreglo, int n) {
        if (n < 2) {
            int arr []= {};
            return arr;
        }
        int mitad = n / 2;
        int[] l = new int[mitad];
        int[] r = new int[n - mitad];

        for (int i = 0; i < mitad; i++) {
            l[i] = arreglo[i];
        }
        for (int i = mitad; i < n; i++) {
            r[i - mitad] = arreglo[i];
        }
        mergeSort(l, mitad);
        mergeSort(r, n - mitad);
        mergeSortAux(arreglo, l, r, mitad, n - mitad);
        return arreglo;
    }
 
    public static void mergeSortAux(int[] arreglo, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arreglo[k++] = l[i++];
            } else {
                arreglo[k++] = r[j++];
            }
        }
        while (i < left) {
            arreglo[k++] = l[i++];
        }
        while (j < right) {
            arreglo[k++] = r[j++];
        }
    }
    public int quickSort(int arr[], int low, int high) 
    { 
        int pivote = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 

            if (arr[j] <= pivote) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
    public void quickSortAux(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pivote = quickSort(arr, low, high); 
            quickSortAux(arr, low, pivote-1); 
            quickSortAux(arr, pivote+1, high); 
        } 
    } 
    public static void main(String[] args) {
        int [] arreglo = new int[(int)Math.floor(Math.random()*(3-40)+40)];
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = (int)Math.floor(Math.random()*(1-200)+200);
        }
        System.out.println("Merge Sort");
        System.out.println("Sin ordenar");
        System.out.println(Arrays.toString(arreglo));
        System.out.println("Ordenado");
        System.out.println(Arrays.toString(mergeSort(arreglo,arreglo.length)));
    }
}
