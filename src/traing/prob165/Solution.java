package traing.prob165;

import utils.PrintUtils;

/**
 * Compare Version Numbers
 * Link: https://leetcode.com/problems/compare-version-numbers/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            if (i == v1.length) return checkAllZero(v2, i) ? 0 : -1;
            if (i == v2.length) return checkAllZero(v1, i) ? 0 : 1;

            Integer i1 = Integer.valueOf(v1[i]);
            Integer i2 = Integer.valueOf(v2[i]);
            if (i1 > i2) return 1;
            else if (i1 < i2) return -1;
        }

        return 0;
    }

    private boolean checkAllZero(String[] data, int start) {
        while (start != data.length) {
            if (Integer.valueOf(data[start++]) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrintUtils.printArray("1.".split("\\."));
        Solution s = new Solution();

        System.out.println(s.compareVersion("1.1", "1"));
        System.out.println(s.compareVersion("1.3.2", "1.1.5"));
        System.out.println(s.compareVersion("1.3.2", "1.3.1.1"));
    }
}
