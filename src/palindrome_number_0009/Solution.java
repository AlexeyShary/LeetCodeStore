// https://leetcode.com/problems/palindrome-number/
package palindrome_number_0009;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int[] digits = new int[10];
        int counter = 0;

        while (x > 0) {
            digits[counter] = x % 10;
            x /= 10;
            counter++;
        }

        for (int i = 0; i < counter / 2; i++) {
            if (digits[i] != digits[counter - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}