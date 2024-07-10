// https://leetcode.com/problems/crawler-log-folder
package crawler_log_folder_1598;

class Solution {
    public int minOperations(String[] logs) {
        int result = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                result = result > 0 ? result - 1 : 0;
                continue;
            }
            if (!log.equals("./")) {
                result++;
            }
        }

        return result >= 0 ? result : 0;
    }
}