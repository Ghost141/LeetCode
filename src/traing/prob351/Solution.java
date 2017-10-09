package traing.prob351;

import java.util.Arrays;

/**
 * Android Unlock Patterns
 * Link: https://leetcode.com/problems/android-unlock-patterns/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    private boolean[] used = new boolean[10];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++) {
            res += calculate(-1, len);
            Arrays.fill(used, false);
        }
        return res;
    }

    private boolean isValid(int index, int last) {
        if (used[index]) return false;

        if (last == -1) return true;

        if ((index + last) % 2 == 1) return true;

        int mid = (index + last) / 2;
        if (mid == 4) return used[mid];
        if ((index % 3 != last % 3) && (index / 3 != last / 3)) return true;
        return used[mid];
    }

    private int calculate (int last, int len) {
        if (len == 0) return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last)) {
                used[i] = true;
                sum += calculate(i, len - 1);
                used[i] = false;
            }
        }
        return sum;
    }
}
