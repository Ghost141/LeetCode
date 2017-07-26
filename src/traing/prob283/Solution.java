package traing.prob283;

import traing.Utils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Move Zeroes
 * Link: https://leetcode.com/problems/move-zeroes/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> indexQueue = new PriorityQueue<>();
        int i = 0;

        for (; i < nums.length; i++) {
            if (nums[i] != 0) indexQueue.add(i);
        }

        i = 0;
        while (!indexQueue.isEmpty()) {
            final Integer ind = indexQueue.poll();
            nums[i] = nums[ind];
            i++;
        }
        for (;i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        int[] data1 = {1, 2, 3, 0};
        s.moveZeroes(data1);
        Utils.printai(data1);

        int[] data2 = {0, 2, 3, 0};
        s.moveZeroes(data2);
        Utils.printai(data2);

        final int[] data3 = {1, 2, 0, 3, 0};
        s.moveZeroes(data3);
        Utils.printai(data3);

        final int[] data4 = {0, 0, 0};
        s.moveZeroes(data4);
        Utils.printai(data4);

        final int[] data5 = {1, 2, 3};
        s.moveZeroes(data5);
        Utils.printai(data5);
    }
}
