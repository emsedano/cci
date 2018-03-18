package stringsandarrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class DoLeftRotation {

    public static void main(String[] args) {
        int[] output = doLeftRotation(new int[]{1,2,3,4,5}, 4) ;
        printArray(output);

    }

    static int[] doLeftRotation(int[]array, int kth) {
        if(array.length  == 1) return array;
        for (int k = 0; k < kth; k++ ) {
            int tmp = array[0];
            for (int i =1; i < array.length; i++) {
                array[i - 1] = array[i];
            }
            array[array.length -1] = tmp;
        }
        return array;
    }

    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
