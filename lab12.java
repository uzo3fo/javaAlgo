import java.util.ArrayList;

public class lab12 {
    static int getSum(int a, int b) {
        // Good luck!
        /*
         * int res = 0; for (int i = Math.min(a, b); i <= Math.max(a, b); i++) { res +=
         * i; } return a == b ? a : res;
         */
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = a;
        if (a == b)
            sum = a;

        if (a > b) {
            for (int i = b; i <= a; i++) {
                nums.add(i);
            }
            sum = nums.stream().reduce(0, (ans, j) -> ans + j);
        }

        if (a < b) {
            for (int i = a; i <= b; i++) {
                nums.add(i);
            }
            sum = nums.stream().reduce(0, (ans, j) -> ans + j);
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(getSum(1, 5));
        System.out.println(getSum(1, 1));
        System.out.println(getSum(-1, 2));
        System.out.println(getSum(11, 2));
    }
}