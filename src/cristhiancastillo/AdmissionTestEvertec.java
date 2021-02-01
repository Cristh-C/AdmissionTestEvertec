/**
 * 
 */
package cristhiancastillo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Clase principal del proyecto AdmissionTestEvertec.
 *
 * @author Cristhian C
 */
public class AdmissionTestEvertec {

    /**
     * @param args Parametro de ejecución.
     * @throws Exception No se cumple con la especificación de la función.
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String functionAndValues = sc.nextLine();
        int index = functionAndValues.indexOf(" ");
        if (index == -1) {
            System.out.println("No se puede continuar, ingrese bien el comando.");
            sc.close();
            throw new Exception();
        }

        String function = functionAndValues.substring(0, index);
        String arrayValues = functionAndValues.substring(index + 1, functionAndValues.length());

        if (function.equalsIgnoreCase("OA")) {
            System.out.println("ORDEN ASCENDENTE");
            Integer[] arrayFinal = getArray(arrayValues);
            Arrays.sort(arrayFinal);
            System.out.println(Arrays.toString(arrayFinal));
            sc.close();
        }
        else if (function.equalsIgnoreCase("OD")) {
            System.out.println("ORDEN DESCENTE");
            Integer[] arrayFinal = getArray(arrayValues);
            Arrays.sort(arrayFinal, Collections.reverseOrder());
            System.out.println(Arrays.toString(arrayFinal));
        }
        else if (function.equalsIgnoreCase("NM")) {
            System.out.println("NUMERO MAYOR");
            Integer[] arrayFinal = getArray(arrayValues);
            int biggerNumber = arrayFinal[0];
            int indexArray = 0;
            for (int i = 0; i < arrayFinal.length; i++) {
                if (arrayFinal[i]>biggerNumber) {
                    biggerNumber = arrayFinal[i];
                    indexArray = i;
                }
            }
            System.out.print("El número mayor es " + biggerNumber + " en el índice ");
            System.out.print(findRepeatedNumber(biggerNumber, arrayFinal, indexArray));
            sc.close();
        }
        else if (function.equalsIgnoreCase("NMN")) {
            System.out.println("NUMERO MENOR");
            Integer[] arrayFinal = getArray(arrayValues);
            int minorNumber = arrayFinal[0];
            int indexArray = 0;
            for (int i = 0; i < arrayFinal.length; i++) {
                if (arrayFinal[i]<minorNumber) {
                    minorNumber = arrayFinal[i];
                    indexArray = i;
                }
            }
            System.out.print("El número menor es " + minorNumber + " en el índice ");
            System.out.print(findRepeatedNumber(minorNumber, arrayFinal, indexArray));
            sc.close();
        }
        else if (function.equalsIgnoreCase("VS")) {
            System.out.println("VALOR TOTAL");
            Integer[] arrayFinal = getArray(arrayValues);
            System.out.println("El valor total del arreglo es " + printTotalSum(0, arrayFinal.length-1, arrayFinal));
            sc.close();
        }
        else if (function.equalsIgnoreCase("VSB")) {
            System.out.println("VALOR TOTAL EN BYTES");
            Integer[] arrayFinal = getArray(arrayValues);
            //arrayInBytes(arrayValues);
            int totalSum = printTotalSum(0, arrayFinal.length-1, arrayFinal);
            System.out.println(arrayInBytes(totalSum));
            sc.close();
        }
        else
            System.out.println("Ingrese un comando correcto.");
    }

    /**
     * Método que obtiene el arreglo de enteros
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     * @return Arreglo de enteros.
     */
    public static Integer[] getArray(String arrayValues) {
        String[] array = arrayValues.split(" ");
        Integer[] arrayFinal = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayFinal[i] = Integer.parseInt(array[i]);
        }
        return arrayFinal;
    }
    
    
    /**
     * Método que calcula la suma del arreglo por medio de recursividad.
     * 
     * @param arrayFinal Arreglo de enteros
     * @param startIndex Inicio del recorrido del arreglo
     * @param endIndex Fin del recorrido del arreglo.
     * @return Valor total del arreglo.
     */
    public static int printTotalSum(int startIndex, int endIndex, Integer[] arrayFinal) {
        if (startIndex == endIndex) {
            return arrayFinal[startIndex];
        } else {
            int middleIndex=(startIndex+endIndex)/2;
            int x = printTotalSum(startIndex, middleIndex, arrayFinal);
            int y = printTotalSum(middleIndex+1, endIndex, arrayFinal);
            return x+y;
        }
    }
    
    /**
     * Método para mostrar el último número repetido encontrado en el arreglo.
     * 
     * @param repeatedNumber Número repetido.
     * @param arrayFinal Arreglo de enteros.
     * @param indexArray Índice del arreglo.
     * @return Índice del arreglo.
     */
    public static int findRepeatedNumber(int repeatedNumber, Integer arrayFinal[], int indexArray) {
        for (int i=0; i < arrayFinal.length; i++) {
            if (repeatedNumber==arrayFinal[i]) {
                indexArray = i;
            }
        }
        return indexArray;
    }
    
    /**
     * Método para convertir la suma total del arreglo en bytes.
     * 
     * @param totalSum Suma total
     * @return Arreglo en bytes.
     * 
     */
    public static byte[] arrayInBytes(int totalSum) {
        
        String totalSumString = String.valueOf(totalSum);
        ArrayList<String> arrayListByte = new ArrayList<>();
        arrayListByte.add(totalSumString);
        byte[] arrayByte = new byte[arrayListByte.size()];
        
        for (int i = 0; i < arrayListByte.size(); i++) {
            arrayByte = arrayListByte.get(i).getBytes();
        }
        
        return arrayByte;

    }
}
