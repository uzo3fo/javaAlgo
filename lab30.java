class lab30 {
    public static void main(String args[]) {
        int i, fact = 1;
        int number = 5;// It is the number to calculate factorial
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + number + " is: " + fact);
    }
}

//number of trailing zeroes of N
public class Solution {
    public static int zeros(int n) {
        if (n / 5 == 0)
            return 0;
        return n / 5 + zeros(n / 5);
    }
}