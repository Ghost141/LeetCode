package traing.prob27;

/**
 * Remove Element
 * Link: https://leetcode.com/problems/remove-element/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1) return nums[0] == val ? 0 : 1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) nums[i++] = nums[j];
        }
        return i;
    }
}
