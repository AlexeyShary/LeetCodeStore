// https://leetcode.com/problems/k-th-smallest-prime-fraction
package k_th_smallest_prime_fraction_0786;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0;
        double right = 1;
        double mid;

        while (left <= right) {

            mid = left + (right - left) / 2;

            int j = 1;
            int count = 0;

            int numerator = 0;
            int denominator = 0;
            double maxFrac = 0;

            for (int i = 0; i < arr.length; ++i) {
                while (j < arr.length && (double) arr[i] / arr[j] >= mid) {
                    ++j;
                }

                count += arr.length - j;

                if (j < arr.length && maxFrac < (double) arr[i] / arr[j]) {
                    maxFrac = (double) arr[i] / arr[j];
                    numerator = i;
                    denominator = j;
                }
            }

            if (count == k) {
                return new int[]{arr[numerator], arr[denominator]};
            }

            if (count > k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return null;
    }
}