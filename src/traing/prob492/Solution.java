package traing.prob492;

import utils.PrintUtils;

/**
 * Construct the Rectangle
 * Link: https://leetcode.com/problems/construct-the-rectangle/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/29/17
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int L = (int) Math.sqrt(area), W = area / L;
        if (W > L) {
            int tmp = W;
            W = L;
            L = tmp;
        }
        while (L * W != area) {
            L++;
            W = area / L;
        }
        res[0] = L;
        res[1] = W;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.constructRectangle(8));
    }
}
