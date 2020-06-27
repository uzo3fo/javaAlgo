
/* You are given an array strarr of strings and an integer k. Your task is to return the first longest string consisting of k consecutive strings taken in the array.

Example:
longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"

n being the length of the string array, if n = 0 or k > n or k <= 0 return "".

Note
consecutive strings : follow one after another without an interruption */
import java.util.*;

class lab17 {

    public static String longestConsec(String[] strarr, int k) {
        // your code
        StringBuilder result = new StringBuilder();
        int n = strarr.length;
        if (n == 0 || k > n || k <= 0) {
            return "";
        }
        String[] newArray = Arrays.copyOfRange(strarr, k - 1, k - 1 + k);
        for (String i : newArray) {
            result.append(i);
        }
        return result.toString();
    }

    /*
     * class LongestConsec { public static String longestConsec(String[] strarr, int
     * k) { if (strarr.length == 0 || k > strarr.length || k <= 0) return "";
     * 
     * String longestStr = ""; for (int index = 0; index < strarr.length - k + 1;
     * index++){ StringBuilder sb = new StringBuilder(); for (int i = index; i <
     * index + k; i++){ sb.append(strarr[i]); } if (sb.toString().length()
     * >longestStr.length()){ longestStr = sb.toString(); } } return longestStr; } }
     */

    public static void main(String[] args) {
        String[] strarr = { "itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck" };
        int k = 2;
        System.out.println(longestConsec(strarr, k));
    }
}