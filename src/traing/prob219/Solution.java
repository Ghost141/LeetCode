package traing.prob219;

import java.util.*;

/**
 * Contains Duplicate II
 * Link: https://leetcode.com/problems/contains-duplicate-ii/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.containsNearbyDuplicate(new int[] {-1, -1}, 1));
    }
}
