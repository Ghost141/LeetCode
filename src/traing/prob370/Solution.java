package traing.prob370;

import utils.PrintUtils;
import utils.DataGenerator;

/**
 * Range Addition
 * Link: https://leetcode.com/problems/range-addition/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] up : updates) {
            res[up[0]] += up[2];
            if (up[1] != length - 1)
                res[up[1] + 1] += -up[2];
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.getModifiedArray(10, DataGenerator.createIntMatrix("2,4,6|5,6,8|1,9,-4")));
    }
}
