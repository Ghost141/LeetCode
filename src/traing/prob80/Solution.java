package traing.prob80;

/**
 * Remove Duplicates from Sorted Array II
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int head = 0;
        for (int num : nums) {
            if (head < 2 || num > nums[head - 2]) {
                nums[head++] = num;
            }
        }
        return head;
    }
}
