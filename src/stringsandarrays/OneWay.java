package stringsandarrays;


/*
* There are three types  of edits, insert, a char, remove a char or replace a char. Given 2 strings, write a func to
* check if they are one edit (or zere) away
* */
public class OneWay {
    public static int OFFSET = (int) 'a';
    public static void main(String args[]) {

        OneWaySolution1 solution1 = new OneWaySolution1();
        OneWaySoluction2 solution2 = new OneWaySoluction2();
        System.out.println("s1: " + solution1.isOneWayEdit("pale", "ple") + ", s2: " + solution2.oneEditWay("pale", "ple")+ ", mine:" + isOneWayEdit("pale", "ple"));    // true removal
        System.out.println("s1: " + solution1.isOneWayEdit("pales", "pale") + ", s2: " + solution2.oneEditWay("pales", "pale")+ ", mine:" + isOneWayEdit("pales", "pale"));  // true insertion
        System.out.println("s1: " + solution1.isOneWayEdit("pale", "bale") + ", s2: " + solution2.oneEditWay("pale", "bale")+ ", mine:" + isOneWayEdit("pale", "bale"));   // replacement
        System.out.println("s1: " + solution1.isOneWayEdit("pale", "baleis") + ", s2: " + solution2.oneEditWay("pale", "baleis")+ ", mine:" + isOneWayEdit("pale", "baleis"));   // replacement
        System.out.println("s1: " + solution1.isOneWayEdit("pale", "bake") + ", s2: " + solution2.oneEditWay("pale", "bake")+ ", mine:" + isOneWayEdit("pale", "bake"));   // false
        System.out.println("s1: " + solution1.isOneWayEdit("apple", "aple") + ", s2: " + solution2.oneEditWay("apple", "aple")+ ", mine:" + isOneWayEdit("apple", "aple"));  // true removal

    }

    static boolean isOneWayEdit(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }
        int[] aMap = toIntArray(a);
        int[] bMap = toIntArray(b);
        for (char bc:  b.toCharArray()) {
            if(aMap[bc-OFFSET] == 0 ) continue;
            aMap[bc - OFFSET] = aMap[bc-OFFSET] - bMap[bc-OFFSET];
        }
        int result = 0;
        for (int val : aMap) result += val;
        return result < 2 && result > -2;
    }

    static int[] toIntArray(String str){
        int[] values = new int[26];
        for(char c : str.toCharArray()){
            values[c - OFFSET]++;
        }
        return values;
    }
}

class OneWaySolution1 {
    boolean isOneWayEdit(String first, String second) {
        if(first.length() == second.length()){
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()){
            return  oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()){
            return  oneEditInsert(second, first);
        }
        return false;
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i=0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index2 < s2.length() && index1 < s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}

class OneWaySoluction2 {
    boolean oneEditWay(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while(index2 < s2.length() && index1 < s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(foundDifference) return false;
                foundDifference = true;

                if(s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }
}

