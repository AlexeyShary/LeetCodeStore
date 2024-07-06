//https://leetcode.com/problems/pass-the-pillow
package pass_the_pillow_2582;

class Solution {
    public int passThePillow(int n, int time) {
        time %= (n - 1) * 2;
        return time <= (n - 1) ? 1 + time : n - (time - (n - 1));
    }
}