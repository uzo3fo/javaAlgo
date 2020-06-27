/* A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.

 For example an extract of one of the stocklists could be:

L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
or

L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :

  M = {"A", "B", "C", "W"} 
or

  M = ["A", "B", "C", "W"] or ...
and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity according to each category.

For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket a list of pairs):

  (A : 20) - (B : 114) - (C : 50) - (W : 0)
where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.

If L or M are empty return string is "" (Clojure and Racket should return an empty array/list instead).

Note:
In the result codes and their values are in the same order as in M */

/* import static java.util.Arrays.stream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingInt;

class StockList {
    static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length > 0 && lstOf1stLetter.length > 0) {
            var counts = stream(lstOfArt)
                    .collect(groupingBy(s -> s.substring(0, 1), summingInt(s -> Integer.parseInt(s.split(" ")[1]))));
            return stream(lstOf1stLetter).map(s -> "(" + s + " : " + counts.getOrDefault(s, 0) + ")")
                    .collect(joining(" - "));
        }
        return "";
    }
} */
/* import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StockList {

    private static class Book {
        public final String category;
        public final String code;
        public final int quantity;

        public Book(String label) {
            category = label.substring(0, 1);
            code = label.split(" ")[0].substring(1);
            quantity = Integer.parseInt(label.split(" ")[1]);
        }
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";
        Map<String, Integer> categoryCounts = Arrays.stream(lstOfArt).map(Book::new)
                .collect(Collectors.groupingBy(book -> book.category, Collectors.summingInt(book -> book.quantity)));
        return Arrays.stream(lstOf1stLetter)
                .map(initial -> String.format("(%s : %d)", initial, categoryCounts.getOrDefault(initial, 0)))
                .collect(Collectors.joining(" - "));
    }
} */
import java.util.Map;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.joining;

public class lab21 {
    private static int stockCount(final String s) {
        return Integer.valueOf(s.split(" ")[1]);
    }

    public static String stockSummary(final String[] stock, final String[] categories) {
        if (stock.length == 0 || categories.length == 0)
            return "";
        final Map<String, Integer> counts = stream(stock)
                .collect(groupingBy(s -> s.substring(0, 1), summingInt(lab21::stockCount)));
        return stream(categories).map(s -> "(" + s + " : " + counts.getOrDefault(s, 0) + ")").collect(joining(" - "));
    }
}