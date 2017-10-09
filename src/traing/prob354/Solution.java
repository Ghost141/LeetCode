package traing.prob354;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Russian Doll Envelopes
 * Link: https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? -Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int ind = Arrays.binarySearch(dp, 0, len, height);
            if (ind < 0) ind = -(ind + 1);
            dp[ind] = height;
            if (ind == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxEnvelopes(DataGenerator.createIntMatrix("3,4|3,3")));
    }
}
