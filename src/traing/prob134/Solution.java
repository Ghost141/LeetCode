package traing.prob134;

/**
 * Gas Station
 * Link: https://leetcode.com/problems/gas-station/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1, end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canCompleteCircuit(new int[]{2, 4}, new int[] {3, 4}));
    }
}
