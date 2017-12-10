package traing.prob740;

import utils.DataGenerator;

/**
 * Delete and Earn
 * Link: https://leetcode.com/problems/delete-and-earn/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/3/17
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num : nums) count[num]++;
        int avoid = 0, using = 0, prev = -1;
        for (int key = 1; key < count.length; key++) {
            if (count[key] == 0) continue;
            int temp = Math.max(avoid, using);
            if (key == prev + 1) {
                using = avoid + key * count[key];
                avoid = temp;
            } else {
                using = temp + key * count[key];
                avoid = temp;
            }

            prev = key;
        }

        return Math.max(avoid, using);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.deleteAndEarn(DataGenerator.createIntArray("3, 4, 2")));
        System.out.println(s.deleteAndEarn(DataGenerator.createIntArray("8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4")));
    }
}
