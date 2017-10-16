package traing.prob350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intersection of Two Arrays II
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/16/17
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1 = 0, ind2 = 0;
        List<Integer> res = new ArrayList<>();

        while (ind1 < nums1.length && ind2 < nums2.length) {
            int n1 = nums1[ind1];
            int n2 = nums2[ind2];
            if (n1 == n2) {
                res.add(nums1[ind1++]);
                ind2++;
            } else if (n1 > n2) {
                ind2++;
            } else {
                ind1++;
            }
        }

        int[] nums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) nums[i] = res.get(i);
        return nums;
    }
}
