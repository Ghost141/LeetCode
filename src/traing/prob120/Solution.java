package traing.prob120;

import java.util.Arrays;
import java.util.List;

/**
 * Triangle
 * Link: https://leetcode.com/problems/triangle/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++)
            dp[i] = triangle.get(triangle.size() - 1).get(i);

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minimumTotal(Arrays.asList(Arrays.asList(-10))));
    }
}
