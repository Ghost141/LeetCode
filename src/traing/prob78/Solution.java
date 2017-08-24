package traing.prob78;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 * Link: https://leetcode.com/problems/subsets/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        sub(set, new ArrayList<>(), nums, 0);
        return new ArrayList<>(set);
    }

    private void sub(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
        list.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            sub(list, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.subsets(DataGenerator.createIntArray("1,2,3")));
    }
}
