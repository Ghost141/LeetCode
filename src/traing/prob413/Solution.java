package traing.prob413;

import utils.DataGenerator;

/**
 * Arithmetic Slices
 * Link: https://leetcode.com/problems/arithmetic-slices/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) return 0;
        int count = 0;
        int diff = A[1] - A[0];
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) {
                len++;
            } else {
                if (len >= 3) {
                    count += (len - 1) * (len - 2) / 2;
                }
                len = 1;
                diff = A[i] - A[i - 1];
                i--;
            }
        }
        return len >= 3 ? count + (len - 1) * (len - 2) / 2 : count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfArithmeticSlices(DataGenerator.createIntArray("1,2,3,8,9,10")));
        System.out.println(s.numberOfArithmeticSlices(DataGenerator.createIntArray("1,1,1,1")));
        System.out.println(s.numberOfArithmeticSlices(DataGenerator.createIntArray("1,1,1,1,2,3,4")));
    }
}
