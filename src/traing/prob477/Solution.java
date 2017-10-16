package traing.prob477;

/**
 * Total Hamming Distance
 * Link: https://leetcode.com/problems/total-hamming-distance/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/16/17
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int x = 0;
        for (int num : nums) x |= num;
        int min = -1, max = 0;
        while (x != 0) {
            if (min < 0 && (x & 1) == 1) min = max;
            x = x >> 1;
            max++;
        }
        int res = 0;
        for (int i = min; i <= max; i++) {
            x = 1 << i;
            int zeroCount = 0, oneCount = 0;
            for (int num : nums) {
                if ((num & x) == 0) zeroCount++;
                else oneCount++;
            }
            res += zeroCount * oneCount;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(1 << 0);
        System.out.println(1 << 1);
    }
}
