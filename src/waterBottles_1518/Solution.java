// https://leetcode.com/problems/water-bottles
package waterBottles_1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles-1)/(numExchange-1);
    }
}