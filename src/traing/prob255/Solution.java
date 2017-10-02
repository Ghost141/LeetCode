package traing.prob255;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Verify Preorder Sequence in Binary Search Tree
 * Link: https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) return false;
            while (!stack.isEmpty() && stack.peek() < num) min = stack.pop();
            stack.push(num);
        }

        return true;
    }
}
