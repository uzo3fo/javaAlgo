
/* StringSplit.solution("abc") // should return {"ab", "c_"}
StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"} */
import java.util.*;

public class lab14 {
    public static String[] solution(String s) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (s.length() % 2 == 1) {
            s = s + "_";
        }
        for (int i = 0; i < s.length() - 1; i += 2) {
            result.add(s.substring(i, i + 2));
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdef"));
    }
}