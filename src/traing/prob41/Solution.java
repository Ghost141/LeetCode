package traing.prob41;

/**
 * First Missing Positive
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/6/17
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i] - 1;
                nums[i] = nums[tmp];
                nums[tmp] = tmp + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
