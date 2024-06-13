// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
package minimum_number_of_moves_to_seat_everyone_2037;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int result = 0;

        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            max = Math.max(max, students[i]);
            max = Math.max(max, seats[i]);
        }
        int[] diff = new int[max];

        for (int i = 0; i < seats.length; i++) {
            diff[seats[i] - 1]++;
            diff[students[i] - 1]--;
        }

        int runningValue = 0;
        for (int i = 0; i < diff.length; i++) {
            result += Math.abs(runningValue);
            runningValue += diff[i];
        }

        return result;
    }
}