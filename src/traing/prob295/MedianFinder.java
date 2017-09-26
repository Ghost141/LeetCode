package traing.prob295;

import java.util.PriorityQueue;

/**
 * Find Median from Data Stream
 * Link: https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/26/17
 */
public class MedianFinder {
    private PriorityQueue<Long> maxHeap = new PriorityQueue<>();
    private PriorityQueue<Long> minHeap = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.offer((long) num);
        minHeap.offer(-maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(-minHeap.poll());
    }

    public double findMedian() {
        return maxHeap.size() == minHeap.size() ? (double) (maxHeap.peek() - minHeap.peek()) / 2 : maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();

        s.addNum(1);
        s.addNum(2);
        s.addNum(3);
        System.out.println(s.findMedian());
    }

}
