package strings;

import java.text.Normalizer;

public class IsUnique {

    public static void main(String args[]) throws Exception{
        System.out.println(isUnique("abcde"));
        System.out.println(isUnique("abcdeá"));
        System.out.println(alternativeIsUnique("abcde"));
        System.out.println(alternativeIsUnique("abcdea"));
        System.out.println(isUnique("abc()"));
        System.out.println(isUnique("abc-"));

    }

    public  static boolean isUnique(String input) throws Exception {
        input = Normalizer.normalize(input, Normalizer.Form.NFD); // get rid off accents
        if(input.length()> 128) { // assumint is ASCII (otherwise we need to increase the char set array size)
            return false; // because we cannot have a value with unique chars if is more thatn 128
        }
        boolean chars[] = new boolean[128];
        for (int i = 0; i < input.length(); i++) { // O(N)
            char current = input.charAt(i);
            if(chars[current]) {
                return false;
            }
            chars[current] = true;
        }
        return true;
    }
    // WTF ???
    public static boolean alternativeIsUnique(String input) {
        int checker = 0;
        for(int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}