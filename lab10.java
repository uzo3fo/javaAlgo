// Java regex program to check for valid string 

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    // Method to check for valid string
    static boolean checkString(String str) {
        // regular expression for invalid string
        String regex = "10+1";

        // compiling regex
        Pattern p = Pattern.compile(regex);

        // Matcher object
        Matcher m = p.matcher(str);

        // loop over matcher
        while (m.find()) {
            // if match found,
            // then string is invalid
            return false;
        }

        // if match doesn't found
        // then string is valid
        return true;
    }

    // Driver method
    public static void main(String[] args) {
        String str = "00011111111100000";

        System.out.println(checkString(str) ? "VALID" : "NOT VALID");
    }
}
