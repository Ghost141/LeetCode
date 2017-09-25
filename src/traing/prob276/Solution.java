package traing.prob276;

/**
 * Paint Fence
 * Link: https://leetcode.com/problems/paint-fence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        else if (n == 1) return k;
        int diff = k * (k - 1);
        int same = k;
        for (int i = 2; i < n; i++) {
            int temp = diff;
            diff = (diff + same) * (k - 1);
            same = temp;
        }
        return same + diff;
    }
}
