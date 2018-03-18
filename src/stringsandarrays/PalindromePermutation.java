package stringsandarrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    /**
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     * */
    public static void main(String args[]) {
        String[] test = new String[] { "Tact Coa", "this is not", "anita lava la anit" };
        for (String item:  test) {
            System.out.println(isPalindrome(item));
        }
    }

    static boolean isPalindrome(String input) {
        input = input.toLowerCase().replace(" ", "");
        Map<Character, Integer> letterMap = toLettersMap(input);
        int oddsCounter = 0;
        for(Integer value: letterMap.values()) {
            if (value % 2 != 0 ) {
                oddsCounter++;
            }
        }
        return oddsCounter <= 1;
    }

    static Map toLettersMap(String input) {
        Map<Character, Integer> lettersMap = new HashMap<>();
        for (Character c : input.toCharArray()) {
            if(lettersMap.containsKey(c)) {
                lettersMap.put(c, new Integer(lettersMap.get(c) + 1));
            } else {
                lettersMap.put(c, 1);
            }
        }
        return lettersMap;
    }
}


class Solution {

    public boolean isPalindrome(String input) {
        int table[] = buildCharFrequency(input);
        return checkMaxOneOdd(table);
    }

    boolean checkMaxOneOdd(int[] table ) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 !=  0) {
                if(foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }

    int[] buildCharFrequency(String phrase) {
        int[] table = new int[Character.getNumericValue('z' - Character.getNumericValue('a') + 1)];
        for(char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}

class Solution2 {

    boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int [] table = new int[Character.getNumericValue('z' - Character.getNumericValue('a')+1)];

        for(char c : phrase.toCharArray()) {
            int x = Solution.getCharNumber(c);
            if(x != -1) {
                table[x]++;
                if(table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
}
