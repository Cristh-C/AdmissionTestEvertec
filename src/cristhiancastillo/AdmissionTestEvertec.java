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

    /** Función de ordenamiento ascendente del arreglo. */
    public static final String ASCENDING_SORT_FUNCTION   = "OA";
    /** Función de ordenamiento descendente del arreglo. */
    public static final String DESCENDING_SORT_FUNCTION  = "OD";
    /** Función que encuentra el número mayor del arreglo. */
    public static final String BIGGER_NUMBER_FUNCTION    = "NM";
    /** Función que encuentra el número menor del arreglo. */
    public static final String MINOR_NUMBER_FUNCTION     = "NMN";
    /** Función que suma los valores del arreglo. */
    public static final String SUM_VALUES_FUNCTION       = "VS";
    /** Función que suma los valores arreglo en bytes. */
    public static final String SUM_VALUES_BYTES_FUNCTION = "VSB";

    /**
     * Método principal, donde se encuentran las instrucciones de ejecución.
     * 
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

        if (function.equalsIgnoreCase(AdmissionTestEvertec.ASCENDING_SORT_FUNCTION)) {
            System.out.println(AdmissionTestEvertec.ascendingOrder(arrayValues));
        }
        else if (function.equalsIgnoreCase(AdmissionTestEvertec.DESCENDING_SORT_FUNCTION)) {
            System.out.println(AdmissionTestEvertec.descendingOrder(arrayValues));
        }
        else if (function.equalsIgnoreCase(AdmissionTestEvertec.BIGGER_NUMBER_FUNCTION)) {
            AdmissionTestEvertec.biggerNumber(arrayValues);
        }
        else if (function.equalsIgnoreCase(AdmissionTestEvertec.MINOR_NUMBER_FUNCTION)) {
            AdmissionTestEvertec.minorNumber(arrayValues);
        }
        else if (function.equalsIgnoreCase(AdmissionTestEvertec.SUM_VALUES_FUNCTION)) {
            AdmissionTestEvertec.totalSum(arrayValues);
        }
        else if (function.equalsIgnoreCase(AdmissionTestEvertec.SUM_VALUES_BYTES_FUNCTION)) {
            AdmissionTestEvertec.totalSumBytes(arrayValues);
        }
        else {
            System.out.println("Ingrese un comando correcto.");
        }
        sc.close();
    }

    /**
     * Método para convertir la suma total del arreglo en bytes.
     * 
     * @param totalSum Suma total.
     * @return Arreglo en bytes.
     */
    private static byte[] arrayInBytes(int totalSum) {
        String totalSumString = String.valueOf(totalSum);
        ArrayList<String> arrayListByte = new ArrayList<>();
        arrayListByte.add(totalSumString);
        byte[] arrayByte = new byte[arrayListByte.size()];
        for (String element : arrayListByte) {
            arrayByte = element.getBytes();
        }
        return arrayByte;
    }

    /**
     * Método que organiza el arreglo en orden ascendente.
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     * @return Arreglo ordenado de forma ascendente en cadena de caractéres.
     */
    private static String ascendingOrder(String arrayValues) {
        System.out.println("ORDEN ASCENDENTE");
        Integer[] arrayFinal = AdmissionTestEvertec.getArray(arrayValues);
        Arrays.sort(arrayFinal);
        return Arrays.toString(arrayFinal);
    }

    /**
     * Método que encuentra el número mayor dentro del arreglo.
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     */
    private static void biggerNumber(String arrayValues) {
        System.out.println("NUMERO MAYOR");
        Integer[] arrayFinal = AdmissionTestEvertec.getArray(arrayValues);
        int biggerNumber = arrayFinal[0];
        int indexArray = 0;
        for (int i = 0; i < arrayFinal.length; i++) {
            if (arrayFinal[i] > biggerNumber) {
                biggerNumber = arrayFinal[i];
                indexArray = i;
            }
        }
        System.out.print("El número mayor es " + biggerNumber + " en el índice ");
        System.out.print(AdmissionTestEvertec.findRepeatedNumber(biggerNumber, arrayFinal, indexArray));
    }

    /**
     * @param arrayValues Cadena con los valores de arreglo.
     * @return Arreglo ordenado de forma descendente en cadena de caractéres.
     */
    private static String descendingOrder(String arrayValues) {
        System.out.println("ORDEN DESCENTE");
        Integer[] arrayFinal = AdmissionTestEvertec.getArray(arrayValues);
        Arrays.sort(arrayFinal, Collections.reverseOrder());
        return Arrays.toString(arrayFinal);
    }

    /**
     * Método para mostrar el último número repetido encontrado en el arreglo.
     * 
     * @param repeatedNumber Número repetido.
     * @param arrayFinal Arreglo de enteros.
     * @param indexArray Índice del arreglo.
     * @return Índice del arreglo.
     */
    private static int findRepeatedNumber(int repeatedNumber, Integer arrayFinal[], int indexArray) {
        for (int i = 0; i < arrayFinal.length; i++) {
            if (repeatedNumber == arrayFinal[i]) {
                indexArray = i;
            }
        }
        return indexArray;
    }

    /**
     * Método que obtiene el arreglo de enteros.
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     * @return Arreglo de enteros.
     */
    private static Integer[] getArray(String arrayValues) {
        String[] array = arrayValues.split(" ");
        Integer[] arrayFinal = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayFinal[i] = Integer.parseInt(array[i]);
        }
        return arrayFinal;
    }

    /**
     * Método que encuentra el número menor dentro del arreglo.
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     */
    private static void minorNumber(String arrayValues) {
        System.out.println("NUMERO MENOR");
        Integer[] arrayFinal = AdmissionTestEvertec.getArray(arrayValues);
        int minorNumber = arrayFinal[0];
        int indexArray = 0;
        for (int i = 0; i < arrayFinal.length; i++) {
            if (arrayFinal[i] < minorNumber) {
                minorNumber = arrayFinal[i];
                indexArray = i;
            }
        }
        System.out.print("El número menor es " + minorNumber + " en el índice ");
        System.out.print(AdmissionTestEvertec.findRepeatedNumber(minorNumber, arrayFinal, indexArray));
    }

    /**
     * Método que calcula la suma del arreglo por medio de recursividad.
     * 
     * @param arrayFinal Arreglo de enteros.
     * @param startIndex Inicio del recorrido del arreglo.
     * @param endIndex Fin del recorrido del arreglo.
     * @return Valor total del arreglo.
     */
    private static int printTotalSum(int startIndex, int endIndex, Integer[] arrayFinal) {
        if (startIndex == endIndex) {
            return arrayFinal[startIndex];
        }
        else {
            int middleIndex = (startIndex + endIndex) / 2;
            int temporaryVariableX = AdmissionTestEvertec.printTotalSum(startIndex, middleIndex, arrayFinal);
            int temporaryVariableY = AdmissionTestEvertec.printTotalSum(middleIndex + 1, endIndex, arrayFinal);
            return temporaryVariableX + temporaryVariableY;
        }
    }

    /**
     * Método que realiza el llamado al método recursivo.
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     */
    private static void totalSum(String arrayValues) {
        System.out.println("VALOR TOTAL");
        Integer[] arrayFinal = AdmissionTestEvertec.getArray(arrayValues);
        System.out.println(
            "El valor total del arreglo es " + AdmissionTestEvertec.printTotalSum(0, arrayFinal.length - 1, arrayFinal));
    }

    /**
     * Método que realiza la conversión de la suma total en bytes.
     * 
     * @param arrayValues Cadena con los valores del arreglo.
     */
    private static void totalSumBytes(String arrayValues) {
        System.out.println("VALOR TOTAL EN BYTES");
        Integer[] arrayFinal = AdmissionTestEvertec.getArray(arrayValues);
        int totalSum = AdmissionTestEvertec.printTotalSum(0, arrayFinal.length - 1, arrayFinal);
        System.out.println(AdmissionTestEvertec.arrayInBytes(totalSum));
    }
}
