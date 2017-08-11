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
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean success = true;
            for (int j = 0; j < n; j++) {
                int p = (i + j) % n;
                tank += gas[p];
                if (tank < cost[p]) {
                    success = false;
                    break;
                } else {
                    tank -= cost[p];
                }
            }
            if (success) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canCompleteCircuit(new int[]{2, 4}, new int[] {3, 4}));
    }
}
