// Java program to remove consonants from a String 

class lab7 {
    static String remVowel(String str) {
        return str.replaceAll("[BCDFGHJKLMNPQRSTVXZbcdfghjklmnpqrstvxz]", "");
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        String str = "GeeeksforGeeks - A Computer Science Portal for Geeks";

        System.out.println(remVowel(str));
    }
}