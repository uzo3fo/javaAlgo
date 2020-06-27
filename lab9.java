
// Java program to check if a URL is valid 
// using java.net.url 
import java.net.URL;

class Test {

    /* Returns true if url is valid */
    public static boolean isValid(String url) {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }

    /* driver function */
    public static void main(String[] args) {
        String url1 = "http://www.geeksforgeeks.org/";
        if (isValid(url1))
            System.out.println("Yes");
        else
            System.out.println("No");

        String url2 = "http:// www.geeksforgeeks.org/";
        if (isValid(url2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
