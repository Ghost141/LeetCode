package traing.prob260;

/**
 * Single Number III
 * Link: https://leetcode.com/problems/single-number-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/5/17
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        xor &= -xor;
        int[] res = new int[2];
        for (int num : nums)
            if ((num & xor) == 0) res[0] ^= num;
            else res[1] ^= num;

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(1 & -1);
        System.out.println(2 & -2);
        System.out.println(3 & -3);
        System.out.println(78 & -78);
    }
}
