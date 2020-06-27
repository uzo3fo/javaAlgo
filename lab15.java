/* The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:

Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}
Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.

Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray. */
/* public class Max {
    public static int sequence(int[] arr) {
        int cur = 0, max = 0;
        for (int i : arr) {
            cur = Math.max(0, cur + i);
            max = Math.max(max, cur);
        }
        return max;
    }
} */
public class lab15 {
    public static int sequence(int[] arr) {
        int maximumSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            currentSum += arr[i];
            for (int j = i; j < arr.length; j++) {
                if (j != arr.length - 1) {
                    currentSum += arr[j + 1];
                }
                if (currentSum > maximumSum) {
                    maximumSum = currentSum;
                }
            }
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(sequence(arr));
        /*
         * System.out.println(sequence({-2, -1, -3, -4, -1, -2, -1, -5, -4}));
         * System.out.println(sequence({}));
         */
    }

}