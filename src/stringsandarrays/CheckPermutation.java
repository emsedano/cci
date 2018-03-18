package stringsandarrays;

import java.util.stream.IntStream;

/**
 *
 * */
public class CheckPermutation {

    public static void main(String []args) {
       System.out.println(isPermutation("substring", "stringsub")); // true
       System.out.println(isPermutation("substring", "stringsus")); // false
    }

    static boolean isPermutation(String first, String second) {
        if(first.length() != second.length()) return false;
        int [] firstArrayValues = toCountCharArray(first);
        for(char c : second.toCharArray()) {
            int targetPosition = c - 'a';
            if(firstArrayValues[targetPosition] > 0) {
                firstArrayValues[targetPosition]--;
            }
        }
        return IntStream.of(firstArrayValues).sum() == 0;
    }

    static int[] toCountCharArray(String input) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1 ];
        for(char c : input.toCharArray()) {
            table[c - 'a']++;
        }
        return table;
    }

}

