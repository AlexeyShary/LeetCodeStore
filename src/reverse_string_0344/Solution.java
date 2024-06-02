// https://leetcode.com/problems/reverse-string
package reverse_string_0344;

class Solution {
    public void reverseString(char[] s) {
        int l = s.length / 2;
        char tmp;
        for (int i = 0; i < l; i++) {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}