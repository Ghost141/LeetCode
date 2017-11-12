package traing.prob724;

import utils.DataGenerator;

/**
 * Find Pivot Index
 * Link: https://leetcode.com/problems/find-pivot-index/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) sum[i + 1] += nums[i] + sum[i];
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == sum[nums.length] - sum[i + 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.pivotIndex(DataGenerator.createIntArray("1,7,3,6,5,6")));
    }
}
