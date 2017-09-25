package traing.prob278;

import traing.common.VersionControl;

/**
 * First Bad Version
 * Link: https://leetcode.com/problems/first-bad-version/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
