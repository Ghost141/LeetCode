package traing.prob45;

/**
 * Jump Game II
 * Link: https://leetcode.com/problems/jump-game-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int level = 0, nextMax = 0, currentMax = 0, i = 0;
        while (currentMax > i - 1) {
            for (; i <= currentMax; i++) {
                level++;
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) return level;
            }
            currentMax = nextMax;
        }
        return 0;
    }
}
