// https://leetcode.com/problems/zigzag-conversion
package zigzag_conversion_0006;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int edgeShift = 2 + (numRows - 2) * 2;

        for (int i = 0; i < numRows; i++) {
            int currentIndex = i;

            boolean isEdge = i == 0 || i == numRows - 1;

            int shift1 = edgeShift - (i * 2);
            int shift2 = edgeShift - shift1;

            boolean useFirstShift = true;

            while (currentIndex < s.length()) {
                sb.append(s.charAt(currentIndex));

                if (isEdge) {
                    currentIndex += edgeShift;
                } else {
                    if (useFirstShift) {
                        currentIndex += shift1;
                        useFirstShift = false;
                    } else {
                        currentIndex += shift2;
                        useFirstShift = true;
                    }
                }
            }
        }

        return sb.toString();
    }
}