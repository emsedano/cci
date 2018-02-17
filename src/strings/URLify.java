package strings;

/**
 * URLIfy: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of sthe string. (Note: Please use character array so that you can perform this operation
 * in place).
 * */
public class URLify {
    public static void main(String args[]) {
        System.out.println(URLify.getURLified("Mr John Smith    ", 13));
        System.out.println(new URLifySolution().URLify("Mr John Smith    ".toCharArray(), 13));
    }

    static String getURLified(String text, int size) {
        int spacesInText = countSpaces(text.toCharArray(), size);
        char[] urlifiedChars = new char[size + (spacesInText*2)];
        int charPivot = 0;
        for (int i = 0; i < size; i++) {
            if (text.charAt(i) != ' ') {
                urlifiedChars[charPivot] = text.charAt(i);
            } else {
                urlifiedChars[charPivot] = '%';
                charPivot++;
                urlifiedChars[charPivot] = '2';
                charPivot++;
                urlifiedChars[charPivot] = '0';
            }
            charPivot++;
        }
        return String.copyValueOf(urlifiedChars);
    }

    private static int countSpaces(char[] charrArray, int size) {
        int spaces = 0;
        for(int i = 0; i < size; i++) {
            if(charrArray[i] == ' ') {
                spaces++;
            }
        }
        return spaces;
    }
}

class URLifySolution {
    public String URLify(char[] str, int truelength) {
        int spceaCount = 0, index, i;
        for ( i = 0; i < truelength; i++) {
            if (str[i] == ' ') {
                spceaCount++;
            }
        }
        index = truelength + (spceaCount * 2);
        if(truelength < str.length) str[truelength] = '\0'; // End array

        for (i = truelength -1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index -1] = '0';
                str[index -2] = '2';
                str[index -3] = '%';
                index = index - 3;
            } else {
                str[index -1] = str[i];
                index--;
            }
        }
        return String.copyValueOf(str);
    }
}