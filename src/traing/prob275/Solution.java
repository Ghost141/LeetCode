package traing.prob275;

import utils.DataGenerator;

/**
 * H-Index II
 * Link: https://leetcode.com/problems/h-index-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (citations[i] < n - i) {
                break;
            }
        }
        return n - 1 - i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hIndex(new int[]{}));
        System.out.println(s.hIndex(DataGenerator.createIntArray("1,2,3")));
        System.out.println(s.hIndex(DataGenerator.createIntArray("0,1,3,5,6")));
        System.out.println(s.hIndex(DataGenerator.createIntArray("0")));
        System.out.println(s.hIndex(DataGenerator.createIntArray("1")));
        System.out.println(s.hIndex(DataGenerator.createIntArray("45")));
    }
}
