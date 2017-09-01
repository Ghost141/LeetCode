package traing.prob665;

import utils.DataGenerator;

/**
 * Non-decreasing Array
 * Link: https://leetcode.com/problems/non-decreasing-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count > 1) return false;
            if (nums[i] < nums[i - 1]) {
                if (i - 2 >= 0 && nums[i] < nums[i - 2]) nums[i] = nums[i - 1];
                else nums[i - 1] = nums[i];
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.checkPossibility(DataGenerator.createIntArray("4,2,3")));
//        System.out.println(s.checkPossibility(DataGenerator.createIntArray("4,2,1")));
//        System.out.println(s.checkPossibility(DataGenerator.createIntArray("2,3,3,2,4")));
        System.out.println(s.checkPossibility(DataGenerator.createIntArray("3,4,2,3")));
    }
}
