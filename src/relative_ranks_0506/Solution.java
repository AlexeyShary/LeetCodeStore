// https://leetcode.com/problems/relative-ranks
package relative_ranks_0506;

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        PriorityQueue<PriseRecord> priseRecords = new PriorityQueue<>(
                (a, b) -> b.score - a.score);

        for (int i = 0; i < score.length; i++) {
            priseRecords.add(new PriseRecord(i, score[i]));
        }

        int currentPlace = 1;
        while (!priseRecords.isEmpty()) {
            PriseRecord record = priseRecords.poll();

            if (currentPlace > 3) {
                result[record.index] = String.valueOf(currentPlace);
            } else {
                switch (currentPlace){
                    case 1:
                        result[record.index] = "Gold Medal";
                        break;
                    case 2:
                        result[record.index] = "Silver Medal";
                        break;
                    case 3:
                        result[record.index] = "Bronze Medal";
                        break;
                }
            }

            currentPlace++;
        }

        return result;
    }
}

class PriseRecord {
    public int index;
    public int score;

    public PriseRecord(int index, int score) {
        this.index = index;
        this.score = score;
    }
}