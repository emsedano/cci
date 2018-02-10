package strings;

import java.util.Scanner;

public class MakingAnagrams {
  private static final int NUMBER_LETTERS = 26;

  public static int getDelta(int[] array1, int[] array2) {
    if(array1.length != array2.length) {
      return -1;
    }

    int delta = 0;
    for(int i = 0; i < array1.length; i++) {
      int difference = Math.abs(array1[i] - array2[i]);
      delta += difference;
    }
    return delta;
  }

  public static int[] getCharCounts(String s) {
    int[] charCount = new int[NUMBER_LETTERS];
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int offset = (int) 'a';
      int code = c - offset;
      charCount[code]++;
    }
    return charCount;
  }

  public static int numberNeeded(String first, String second) {
    int[] charCount1 = getCharCounts(first);
    int[] charCount2 = getCharCounts(second);
    return getDelta(charCount1, charCount2);
  }

  public static void main(String [] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }
}
