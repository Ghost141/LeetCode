package traing.prob287;

/**
 * Find the Duplicate Number
 * Link: https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 0) {
            int fast = nums[nums[0]], slow = nums[0];
            while (slow != fast) {
                fast = nums[nums[fast]];
                slow = nums[slow];
            }
            fast = 0;
            while (slow != fast) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
