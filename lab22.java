/* You are going to be given an array of integers.Your job is to take that array and find an index N where the sum of the integers to the left of N is equal to the sum of the integers to the right of N.If there is no index that would make this happen,return-1.

For example:

Let'ssay you are given the array{1,2,3,4,3,2,1}:Your function will return the index 3,because at the 3 rd position of the array,the sum of left side of the index({1,2,3})and the sum of the right side of the index({3,2,1})both equal 6.

Let'slook at another one.You are given the array{1,100,50,-51,1,1}:Your function will return the index 1,because at the 1 st position of the array,the sum of left side of the index({1})and the sum of the right side of the index({50,-51,1,1})both equal 1.

Last one:You are given the array{20,10,-80,10,10,15,35}At index 0 the left side is{}The right side is{10,-80,10,10,15,35}They both are equal to 0 when added.(Empty arrays are equal to 0 in this problem)Index 0 is the place where the left side and right side are equal.

Note:Please remember that in most programming/scripting languages the index of an array starts at 0.

Input:An integer array of length 0<arr<1000. The numbers in the array can be any integer positive or negative.

Output:The lowest index N where the side to the left of N is equal to the side to the right of N.If you do not find an index that fits these rules,then you will return-1.

Note:If you are given an array with multiple answers,return the lowest correct index. */
/* import java.util.Arrays;

public class Kata {
    public static int findEvenIndex(int[] arr) {
        int sumRight = Arrays.stream(arr).sum() - arr[0];
        int sumLeft = 0;
        for (int i = 1; i < arr.length; i++) {
            sumLeft += arr[i-1];
            sumRight -= arr[i];
            if (sumLeft == sumRight) return i;
        }
        return -1;
    }
} */

import java.util.*;

public class lab22 {
    public static int equaIndex(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                return 0;
            }
        }
        int index = 1;

        while (index < arr.length) {
            int[] left = Arrays.copyOfRange(arr, 0, index);
            int[] right = Arrays.copyOfRange(arr, index + 1, arr.length);
            int leftSum = Arrays.stream(left).reduce(0, (a, b) -> a + b);
            int rightSum = Arrays.stream(right).reduce(0, (a, b) -> a + b);
            if (leftSum == rightSum)
                break;
            index++;
            if (index == arr.length && leftSum != rightSum)
                return -1;

        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 3, -3 };
        System.out.println(equaIndex(arr));
    }
}