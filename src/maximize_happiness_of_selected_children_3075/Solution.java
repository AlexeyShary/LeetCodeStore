// https://leetcode.com/problems/maximize-happiness-of-selected-children
package maximize_happiness_of_selected_children_3075;

import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;

        Arrays.sort(happiness);

        for (int i = 0; i < k; i++) {
            int element = happiness[happiness.length - 1 - i] - i;

            if (element >= 0) {
                result += element;
            } else {
                break;
            }
        }

        return result;
    }
}