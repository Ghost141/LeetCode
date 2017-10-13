package traing.prob4;

/**
 * Median of Two Sorted Arrays
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/13/17
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (n < m) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = n; n = m; m = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) iMin++;
            else if (i > iMin && nums1[i - 1] > nums2[j]) iMax--;
            else {
                int maxLeft;
                if (i ==0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight;
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0;
    }
}
