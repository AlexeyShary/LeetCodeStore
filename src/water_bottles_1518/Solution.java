// https://leetcode.com/problems/water-bottles
package water_bottles_1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles-1)/(numExchange-1);
    }
}