/* My little sister came back home from school with the following task: given a squared sheet of paper she has to cut it in pieces which, when assembled, give squares the sides of which form an increasing sequence of numbers. At the beginning it was lot of fun but little by little we were tired of seeing the pile of torn paper. So we decided to write a program that could help us and protects trees.

Task
Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².

If there are multiple solutions (and there will be), return as far as possible the result with the largest possible values:

Examples
decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.

For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.

Note
Neither [n] nor [1,1,1,…,1] are valid solutions. If no valid solution exists, return nil, null, Nothing, None (depending on the language) or "[]" (C) ,{} (C++), [] (Swift, Go).

The function "decompose" will take a positive integer n and return the decomposition of N = n² as:

[x1 ... xk] or
"x1 ... xk" or
Just [x1 ... xk] or
Some [x1 ... xk] or
{x1 ... xk} or
"[x1,x2, ... ,xk]"
depending on the language (see "Sample tests")

Note for Bash
decompose 50 returns "1,3,5,8,49"
decompose 4  returns "Nothing"
Hint
Very often xk will be n-1. */

// If no valid solution exists return null
import java.util.ArrayList;
import java.util.List;

public class Decompose {

    public String decompose(long n) {
        List<Long> decomposeArray = Decomposer(n, n * n);

        // no valid solution exists
        if (decomposeArray == null)
            return null;

        // remove the last element
        decomposeArray.remove(decomposeArray.size() - 1);
        List<String> result = new ArrayList<>();

        for (Long ele : decomposeArray) {
            result.add(String.valueOf(ele.longValue()));
        }

        return String.join(" ", result);
    }

    /**
     * Recursion to get the list of decompose
     * 
     * @param n
     * @param remain
     * @return
     */
    public List<Long> Decomposer(long n, long remain) {
        // basic case
        if (remain == 0) {
            List<Long> r = new ArrayList<Long>();
            r.add(n);
            return r;
        }

        // iterate all element less than n
        for (long i = n - 1; i > 0; i--) {
            if ((remain - i * i) >= 0) {
                List<Long> r = Decomposer(i, (remain - i * i));

                // only get the answer
                if (r != null) {
                    r.add(n);
                    return r;
                }
            }
        }

        // no answer
        return null;
    }
}

/*
 * public class Decompose {
 * 
 * private String tryDecomp(long nb, long rac) { if (nb == 0) return ""; String
 * l = null; long i = rac; while (i >= (long) Math.sqrt(nb / 2.0) + 1) { long
 * diff = nb - i * i; rac = (long) Math.sqrt(diff); l = tryDecomp(diff, rac); if
 * (l != null) { return l + " " + i; } i -= 1; } return null; }
 * 
 * public String decompose(long n) { String l = tryDecomp(n * n, (long)
 * Math.sqrt(n * n - 1)); return l != null ? l.trim() : l; } }
 */