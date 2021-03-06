
/* You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Implement a function likes :: [String] -> String, which must take in input array, containing the names of people who like an item. It must return the display text as shown in the examples:

likes {} // must be "no one likes this"
likes {"Peter"} // must be "Peter likes this"
likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this"
likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like this"
For 4 or more names, the number in and 2 others simply increases. */
/* class Solution {
    public static String whoLikesIt(String... names) {
        switch (names.length) {
          case 0: return "no one likes this";
          case 1: return String.format("%s likes this", names[0]);
          case 2: return String.format("%s and %s like this", names[0], names[1]);
          case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
          default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
} */
import java.util.*;

public class lab24 {
    public static String whoLikesIt(String... names) {
        // Do your magic here
        String result = "";
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(names));

        if (names.length == 0)
            result = "no one likes this";
        if (names.length == 1) {
            String first = list.get(0);
            result = first + " likes this";
        }
        if (names.length == 2) {
            String first = list.get(0);
            String second = list.get(1);
            result = first + " and " + second + " like this";
        }
        if (names.length == 3) {
            String first = list.get(0);
            String second = list.get(1);
            String third = list.get(2);
            result = first + ", " + second + " and " + third + " like this";
        }
        if (names.length > 3) {
            String first = list.get(0);
            String second = list.get(1);
            int others = list.subList(2, list.size()).size();
            result = first + ", " + second + " and " + others + " others like this";
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {};
        System.out.println(whoLikesIt(str));
    }
}