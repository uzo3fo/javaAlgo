/* Complete the solution so that the function will break up camel casing, using a space between words.

Example
solution("camelCasing")  ==  "camel Casing" */

public class lab20 {
    public static String[] breakCase(String str) {
        // StringBuilder builder = new StringBuilder();
        String[] arr = str.split(",");
        return arr;
        /*
         * for (String c : arr) { if (c.equals(c.toUpperCase())) { builder.append(" " +
         * c); } builder.append(c); } return arr;//builder.toString();
         */
    }

    public static void main(String[] args) {
        String str = "camelCase";
        System.out.println(breakCase(str));
    }
}