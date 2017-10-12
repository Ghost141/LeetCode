package traing.prob503;

/**
 * Next Greater Element II
 * Link: https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * @author zhaokai
 * @version 1.0 - Brute force solution.
 * @since 1.0 - 10/12/17
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        return bruteForce(nums);
    }

    private int[] bruteForce(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int ind = -1, j = i + 1, count = 0;
            for (; count < nums.length; count++) {
                if (nums[(j + count) % nums.length] > nums[i]) {
                    ind = (j + count) % nums.length;
                    break;
                }
            }
            res[i] = ind == -1 ? -1 : nums[(j + count) % nums.length];
        }
        return res;
    }
}
