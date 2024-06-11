// https://leetcode.com/problems/subarray-sums-divisible-by-k
package subarray_sums_devisible_by_k_0974;

import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;

        int prefixSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        for (int value : nums) {
            prefixSum += value;
            int reminder = prefixSum % k;
            if (reminder < 0) {
                reminder += k;
            }
            if (prefixMap.containsKey(reminder)) {
                result += prefixMap.get(reminder);
                prefixMap.put(reminder, prefixMap.get(reminder) + 1);
            } else {
                prefixMap.put(reminder, 1);
            }
        }

        return result;
    }
}