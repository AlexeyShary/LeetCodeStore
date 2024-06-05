// https://leetcode.com/problems/roman-to-integer/
package roman_to_integer_0013;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> table = new HashMap<>();

        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                result += table.get(s.charAt(i));
                continue;
            }

            switch (s.charAt(i)) {
                case 'I':
                    if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
                case 'X':
                    if (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'C':
                    if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                default:
                    result += table.get(s.charAt(i));
            }
        }

        return result;
    }
}