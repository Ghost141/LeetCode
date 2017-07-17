package traing.prob217;

import java.util.Arrays;

/**
 * Problem 217. Contains Duplicate.
 *
 * @author zhaokai
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
