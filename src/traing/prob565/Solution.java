package traing.prob565;

import java.util.HashSet;
import java.util.Set;

/**
 * Array Nesting
 * Link: https://leetcode.com/problems/array-nesting/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int maxSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = i, size = 0;
            if (set.contains(nums[start])) continue;
            while (true) {
                if (set.contains(nums[start])) {
                    maxSize = Math.max(size, maxSize);
                    break;
                } else {
                    size++;
                    set.add(nums[start]);
                    start = nums[start];
                }
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.arrayNesting(new int[] {5, 4, 0, 3, 1, 6, 2}));
    }
}
