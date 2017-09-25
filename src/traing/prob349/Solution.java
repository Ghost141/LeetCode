package traing.prob349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Intersection of Two Arrays
 * Link: https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        Set<Integer> set1Copy = new HashSet<>(set1);
        set1.removeAll(set2);
        set1Copy.removeAll(set1);
        int[] res = new int[set1Copy.size()];
        int i = 0;
        for (Integer in : set1Copy) {
            res[i++] = in;
        }
        return res;
    }
}
