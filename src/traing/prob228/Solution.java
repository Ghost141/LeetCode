package traing.prob228;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * Link: https://leetcode.com/problems/summary-ranges/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/22/17
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int begin = nums[0], end = nums[0];
        List<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end + 1) {
                add(res, begin, end);
                begin = end = nums[i];
            } else end = nums[i];
        }
        add(res, begin, end);

        return res;
    }

    private void add(List<String> res, int begin, int end) {
        res.add(begin == end ? String.valueOf(begin) : begin + "->" + end);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.summaryRanges(DataGenerator.createIntArray("0,1,2,4,5,7")));
        System.out.println(s.summaryRanges(DataGenerator.createIntArray("0")));
        System.out.println(s.summaryRanges(DataGenerator.createIntArray("0,1,2,3,4,5")));
        System.out.println(s.summaryRanges(DataGenerator.createIntArray("0,2,3,4,6,8,9")));
        System.out.println(s.summaryRanges(DataGenerator.createIntArray("0,2,3,4,6,8,9,100")));
    }
}
