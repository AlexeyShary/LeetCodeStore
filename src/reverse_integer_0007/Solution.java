// https://leetcode.com/problems/reverse-integer
package reverse_integer_0007;

class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean sign = x >= 0;
        x = Math.abs(x);

        while (x != 0) {
            int digit = x % 10;
            int controlResult = result;
            result = result * 10 + digit;

            if (((result - digit) / 10) != controlResult) {
                return 0;
            }

            x /= 10;
        }

        return sign ? result : result * -1;
    }
}