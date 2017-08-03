package traing.prob198;

/**
 * House Robber
 * Link: https://leetcode.com/problems/house-robber/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/3/17
 */
public class Solution {
    public int rob(int[] nums) {
        int no = 0, yes = 0;
        for (int n : nums) {
            int tmp = no;
            no = Math.max(no, yes);
            yes = n + tmp;
        }

        return Math.max(no, yes);
    }
}
