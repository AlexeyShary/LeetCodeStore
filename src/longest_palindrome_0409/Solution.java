// https://leetcode.com/problems/longest-palindrome
package longest_palindrome_0409;

import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        int result = 0;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean takeOneOdd = true;

        for (int freq : freqMap.values()) {
            result += (freq / 2) * 2;

            if (takeOneOdd && freq % 2 == 1) {
                result++;
                takeOneOdd = false;
            }
        }

        return result;
    }
}