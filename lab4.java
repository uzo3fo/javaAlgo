/* You have an array of numbers. Your task is to sort ascending odd numbers but even numbers must be on their places.  Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.  Example  sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4] */

import java.util.*;

public class lab4 {

    public static int[] sortArray(final int[] array) {

        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1)
                array[j] = sortedOdd[s++];
        }

        return array;
    }

}
