public class lab13 {

    public static String accum(String s) {
        StringBuilder bldr = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i > 0)
                bldr.append('-');
            bldr.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++)
                bldr.append(Character.toLowerCase(c));
            i++;
        }
        return bldr.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("RqaEzty"));
    }
}