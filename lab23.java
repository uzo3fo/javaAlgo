
/* Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched. simple pig latin

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway ! */
//import java.util.*;

public class lab23 {
    public static String pigIt(String str) {
        // Write code here
        StringBuilder builder = new StringBuilder();
        String[] arr = str.split(" ");
        for (String s : arr) {
            String first = s.substring(0, 1);
            String others = s.substring(1);
            builder.append(others + first + "ay" + " ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String str = "Pig latin is cool";
        System.out.println(pigIt(str));
    }
}