
/* "7777...8?!??!",exclaimed Bob,"I missed it again! Argh!"Every time there'san interesting number coming up,he notices and then promptly forgets.Who doesn'tlike catching those one-off interesting mileage numbers?In this kata you have to create all permutations of an input string and remove duplicates,if present.This means,you have to shuffle all letters from the input in all possible orders.

Let'smake it so Bob never misses another interesting number.We've hacked into his car'scomputer,and we have a box hooked up that reads mileage numbers.We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2(respectively).

It'sup to you,intrepid warrior,to glue the parts together.Write the function that parses the mileage number input,and returns a 2 if the number is"interesting"(see below),a 1 if an interesting number occurs within the next two miles,or a 0 if the number is not interesting.

"Interesting"Numbers Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

Any digit followed by all zeros:100,90000 Every digit is the same number:1111 The digits are sequential,incementing†:1234 The digits are sequential,decrementing‡:4321 The digits are a palindrome:1221 or 73837 The digits match one of the values in the awesomePhrases array†For incrementing sequences,0 should come after 9,and not before 1,as in 7890.‡For decrementing sequences,0 should come after 1,and not before 9,as in 3210.

So,you should expect these inputs and outputs:

// "boring" numbers
CarMileage.isInteresting(3,new int[]{1337,256}); // 0
CarMileage.isInteresting(3236,new int[]{1337,256}); // 0

// progress as we near an "interesting" number
CarMileage.isInteresting(11207,new int[]{}); // 0
CarMileage.isInteresting(11208,new int[]{}); // 0
CarMileage.isInteresting(11209,new int[]{}); // 1
CarMileage.isInteresting(11210,new int[]{}); // 1
CarMileage.isInteresting(11211,new int[]{}); // 2

// nearing a provided "awesome phrase"
CarMileage.isInteresting(1335,new int[]{1337,256}); // 1
CarMileage.isInteresting(1336,new int[]{1337,256}); // 1
CarMileage.isInteresting(1337,new int[]{1337,256}); // 2
Error Checking A number is only interesting if it is greater than 99!Input will always be an integer greater than 0,and less than 1,000,000,000 The awesomePhrases array will always be provided,and will always be an array,but may be empty.(Not everyone thinks numbers spell funny words...)You should only ever output 0,1,or 2
 */
import java.util.regex.Pattern;
import java.lang.StringBuffer;

public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        int rtnval = 0;
        if ((firstRule(number) || secondRule(number) || thirdRule(number) || fourthRule(number) || fifthRule(number)
                || sixthRule(number, awesomePhrases)) && (Integer.toString(number).length() >= 3)) {
            rtnval = 2;
        } else if (((firstRule(number + 1) || secondRule(number + 1) || thirdRule(number + 1) || fourthRule(number + 1)
                || fifthRule(number + 1) || sixthRule(number + 1, awesomePhrases))
                && (Integer.toString(number + 1).length() >= 3))
                || ((firstRule(number + 2) || secondRule(number + 2) || thirdRule(number + 2) || fourthRule(number + 2)
                        || fifthRule(number + 2) || sixthRule(number + 2, awesomePhrases))
                        && (Integer.toString(number + 2).length() >= 3))) {
            rtnval = 1;
        }

        return rtnval;
    }

    // Any digit followed by all zeros
    private static boolean firstRule(int number) {
        String numberString = Integer.toString(number);
        return Pattern.matches("[1-9]0+", numberString);
    }

    // Every Digit is the same number
    private static boolean secondRule(int number) {
        String numberString = Integer.toString(number);
        String replacedString = numberString.replaceAll(numberString.substring(0, 1), "");
        return replacedString.length() == 0;
    }

    // The digits are sequential, incrementing
    private static boolean thirdRule(int number) {
        String numberString = Integer.toString(number);
        char currChar = numberString.charAt(0);
        for (int i = 1; i < numberString.length(); i++) {
            if ((currChar == '9' && numberString.charAt(i) == '0') || (currChar == numberString.charAt(i) - 1)) {
                currChar = numberString.charAt(i);
            } else {
                return false;
            }
        }
        return true;
    }

    // The digits are sequential, decrementing
    private static boolean fourthRule(int number) {
        String numberString = Integer.toString(number);
        char currChar = numberString.charAt(0);
        for (int i = 1; i < numberString.length(); i++) {
            if ((currChar == '1' && numberString.charAt(i) == '0') || (currChar - 1 == numberString.charAt(i))) {
                currChar = numberString.charAt(i);
            } else {
                return false;
            }
        }
        return true;
    }

    // The digits are a palindrome
    private static boolean fifthRule(int number) {
        StringBuffer numberString = new StringBuffer(Integer.toString(number));

        return numberString.toString().equals(numberString.reverse().toString());
    }

    // The digits match one of the values in the awesomePhrases array
    private static boolean sixthRule(int number, int[] awesomePhrases) {
        for (int i = 0; i < awesomePhrases.length; i++) {
            if (awesomePhrases[i] == number) {
                return true;
            }
        }
        return false;
    }
}