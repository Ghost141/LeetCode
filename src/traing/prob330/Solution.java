package traing.prob330;

/**
 * Patching Array
 * Link: https://leetcode.com/problems/patching-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/3/17
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int miss = 1, patches = 0, ind = 0;
        while (miss <= n) {
            if (ind < nums.length && nums[ind] <= miss) miss += nums[ind++];
            else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }
}
