package traing.prob220;

import utils.DataGenerator;

import java.util.TreeSet;

/**
 * Contains Duplicate III
 * Link: https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/22/17
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer greater = set.ceiling(nums[i]);
            if (greater != null && (long) greater <= (long) nums[i] + t) return true;
            Integer smaller = set.floor(nums[i]);
            if (smaller != null && (long) smaller + t >= nums[i]) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.containsNearbyAlmostDuplicate(DataGenerator.createIntArray("-1,-1"), 1, 0));
    }
}
