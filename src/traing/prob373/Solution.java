package traing.prob373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find K Pairs with Smallest Sums
 * Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0 || k < 1) return res;
        PriorityQueue<Data> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        heap.offer(new Data(0, 0, nums1[0] + nums2[0]));

        while (!heap.isEmpty() && k > 0) {
            Data data = heap.poll();
            int[] pair = new int[] {nums1[data.i], nums2[data.j]};
            res.add(pair);
            k--;
            if (data.j < n - 1) {
                heap.offer(new Data(data.i, data.j + 1, nums1[data.i] + nums2[data.j + 1]));
            }
            if (data.j == 0 && data.i < m - 1) {
                heap.offer(new Data(data.i + 1, 0, nums1[data.i + 1] + nums2[0]));
            }
        }
        return res;
    }

    class Data {
        int i;
        int j;
        int val;

        public Data(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
