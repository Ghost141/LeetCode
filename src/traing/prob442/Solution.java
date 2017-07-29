package traing.prob442;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array
 * Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 * @author zhaokai
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            final int position = (nums[i] - 1) % n;
            nums[position] += n;
        }
        final ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > n * 2) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
