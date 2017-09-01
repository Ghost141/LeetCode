package traing.prob213;

import utils.DataGenerator;

/**
 * House Robber II
 * Link: https://leetcode.com/problems/house-robber-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(_rob(nums, 0, nums.length - 2), _rob(nums, 1, nums.length - 1));
    }

    private int _rob(int[] nums, int start, int end) {
        int no = 0, yes = 0;
        for (int i = start; i <= end; i++) {
            int tmp = yes;
            yes = no + nums[i];
            no = Math.max(no, tmp);
        }
        return Math.max(no, yes);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.rob(DataGenerator.createIntArray("1,1,1")));
        System.out.println(s.rob(DataGenerator.createIntArray("1,1")));
    }
}
