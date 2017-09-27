package traing.prob315;

import utils.DataGenerator;

import java.util.*;

/**
 * Count of Smaller Numbers After Self
 * Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/27/17
 */
public class Solution {
    class Node {
        Node left, right;
        int val, sum = 0, dup = 1;
        Node(int v, int s) {
            this.val = v;
            this.sum = s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--)
            root = insert(nums[i], root, res, i, 0);
        return Arrays.asList(res);
    }

    private Node insert(int num, Node node, Integer[] res, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            res[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            res[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, res, i, preSum);
        } else {
            node.right = insert(num, node.right, res, i, preSum + node.sum + node.dup);
        }
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countSmaller(DataGenerator.createIntArray("5,2,6,1")));
    }
}
