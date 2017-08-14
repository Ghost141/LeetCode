package traing.prob532;

import java.util.Arrays;

/**
 * K-diff Pairs in an Array
 * Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0, j = 1; i < j && j < nums.length; ) {
            int diff = nums[j] - nums[i];
            if (i == j) j++;
            if (diff == k) {
                count++;
                j++;
                while (j < nums.length && nums[j] == nums[j - 1]) j++;
            } else if (diff > k) {
                if (i == j - 1) {
                    j++;
                }
                i++;
            } else {
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

        System.out.println(ss.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(ss.findPairs(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(ss.findPairs(new int[]{1, 2}, 0));
        System.out.println(ss.findPairs(new int[]{1, 1, 1, 2}, 0));
        System.out.println(ss.findPairs(new int[]{1, 2, 2, 2}, 0));
        System.out.println(ss.findPairs(new int[]{1, 2, 2, 2}, 1));
        System.out.println(ss.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(ss.findPairs(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(ss.findPairs(new int[]{1, 1, 1, 2, 2}, 0));
    }
}
