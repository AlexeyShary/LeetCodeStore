// https://leetcode.com/problems/string-to-integer-atoi/
package string_to_integer_atoi_0008;

class Solution {
    public int myAtoi(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        boolean skipWhitespace = true;
        boolean isValueReadStarted = false;
        boolean isPositive = true;

        for (char c : chars) {
            if (skipWhitespace && c == 32) {
                continue;
            }
            skipWhitespace = false;

            if (!isValueReadStarted && (c == 43 || c == 45)) {
                if (c == 45) {
                    isPositive = false;
                }
                isValueReadStarted = true;
                continue;
            }
            isValueReadStarted = true;

            if (c >= 48 && c <= 57) {
                int digit = c - 48;
                int preResult = result;

                result = (result * 10) + digit;

                if (result / 10 != preResult) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        return isPositive ? result : result * -1;
    }
}