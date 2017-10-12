package traing.prob88;

/**
 * Merge Sorted Array
 * Link: https://leetcode.com/problems/merge-sorted-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/12/17
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind1 = m - 1, ind2 = n - 1, ind = m + n - 1;
        for (; ind1 >= 0 && ind2 >= 0; ind--) {
            if (nums1[ind1] >= nums2[ind2]) nums1[ind] = nums1[ind1--];
            else nums1[ind] = nums2[ind2--];
        }
        if (ind1 >= 0) while (ind1 >= 0) nums1[ind--] = nums1[ind1--];
        if (ind2 >= 0) while (ind2 >= 0) nums1[ind--] = nums2[ind2--];
    }
}
