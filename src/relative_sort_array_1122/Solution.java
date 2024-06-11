// https://leetcode.com/problems/relative-sort-array
package relative_sort_array_1122;

import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    result[index] = arr1[j];
                    arr1[j] = -1;
                    index++;
                }
            }
        }

        int[] remainder = new int[arr1.length - index];
        int remainderIndex = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] >= 0) {
                remainder[remainderIndex] = arr1[i];
                remainderIndex++;
            }
        }

        Arrays.sort(remainder);
        remainderIndex = 0;

        for (int i = index; i < arr1.length; i++) {
            result[i] = remainder[remainderIndex];
            remainderIndex++;
        }

        return result;
    }
}