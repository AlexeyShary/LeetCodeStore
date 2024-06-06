// https://leetcode.com/problems/hand-of-straights
package hand_of_straights_0846;

import java.util.Arrays;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        int groupsCount = hand.length / groupSize;

        while (groupsCount > 0) {
            int pickedCard = 0;
            int pickedCount = 0;

            for (int i = 0; i < hand.length; i++) {
                if (pickedCount == groupSize) {
                    break;
                }

                if (pickedCount == 0 && hand[i] >= 0) {
                    pickedCard = hand[i];
                    hand[i] = -1;
                    pickedCount++;
                    continue;
                }

                if (hand[i] == pickedCard + 1) {
                    pickedCard = hand[i];
                    hand[i] = -1;
                    pickedCount++;
                }
            }

            if (pickedCount < groupSize) {
                return false;
            }
            groupsCount--;
        }

        return true;
    }
}