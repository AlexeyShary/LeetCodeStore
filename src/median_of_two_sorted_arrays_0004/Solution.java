// https://leetcode.com/problems/median-of-two-sorted-arrays/

package median_of_two_sorted_arrays_0004;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int fullSize = nums1.length + nums2.length;

        if (fullSize == 0) {
            return 0.0;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = fullSize / 2;
        int currentValue = 0;

        boolean pickLastOnly = fullSize % 2 == 1;
        boolean skipCompare = false;

        for (int i = 0; i < targetIndex + 1; i++) {
            if (leftIndex == nums1.length) {
                currentValue = nums2[rightIndex];
                rightIndex++;
                skipCompare = true;
            }

            if (rightIndex == nums2.length && !skipCompare) {
                currentValue = nums1[leftIndex];
                leftIndex++;
                skipCompare = true;
            }

            if (skipCompare) {
                skipCompare = false;
            } else {
                if (nums1[leftIndex] <= nums2[rightIndex]) {
                    currentValue = nums1[leftIndex];
                    leftIndex++;
                } else {
                    currentValue = nums2[rightIndex];
                    rightIndex++;
                }
            }

            if (pickLastOnly && i == targetIndex) {
                return (double) currentValue;
            }

            if (!pickLastOnly && (i == targetIndex || i == targetIndex - 1)) {
                result += currentValue;
            }
        }

        return result / 2.0;
    }
}