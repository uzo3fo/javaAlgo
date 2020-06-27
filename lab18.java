
/* Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings. All words must have their first letter capitalized without spaces.

For instance:

camelCase("hello case"); // => "HelloCase"
camelCase("camel case word"); // => "CamelCaseWord" */

public class lab18 {

    public static String camelCase(String str) {
        // your code here
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (string.length() > 0) {
                stringBuilder.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
            }

        }
        return new String(stringBuilder);
    }

    public static void main(String[] args) {
        String tr = "hello case";

        System.out.println(camelCase(tr));
    }
}