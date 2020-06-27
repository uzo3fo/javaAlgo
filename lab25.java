
/*
 * Write Number in Expanded Form You will be given a number and you will need to
 * return it as a string in Expanded Form. For example:
 * 
 * Kata.expandedForm(12); # Should return "10 + 2" Kata.expandedForm(42); #
 * Should return "40 + 2" Kata.expandedForm(70304); # Should return
 * "70000 + 300 + 4" NOTE: All numbers will be whole numbers greater than 0.
 */
/* String outs = "";
       for (int i = 10; i < num; i *= 10) {
           int rem = num % i;
           outs = (rem > 0) ? " + " + rem + outs : outs;
           num -= rem;
       }
       outs = num + outs;
       
       return outs; */
import java.util.*;

public class lab25 {
    public static String expandedForm(int num) {
        String zero = "0";
        StringBuilder builder = new StringBuilder();
        StringBuffer build = new StringBuffer();
        ArrayList<Integer> stack = new ArrayList<Integer>();
        while (num > 0) {
            stack.add(num % 10);
            num = num / 10;
        }
        ListIterator<Integer> it = stack.listIterator();
        while (it.hasNext()) {
            String str = it.next().toString();
            int index = it.nextIndex();
            builder.append(str + zero.repeat(index - 1) + " ");
        }
        String co = builder.toString();
        String[] arr = co.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Integer.parseInt(arr[i]) > 0) {
                build.append(" + " + arr[i]);
            }
        }
        return build.deleteCharAt(1).toString().trim();
    }

    public static void main(String[] args) {
        int num = 70300;
        System.out.println(expandedForm(num));
    }
}