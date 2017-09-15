package traing.prob117;

import traing.common.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Populating Next Right Pointers in Each Node II
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/15/17
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        Deque<TreeLinkNode> tmp = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            node.next = queue.peek();
            if (node.left != null) tmp.offer(node.left);
            if (node.right != null) tmp.offer(node.right);

            if (queue.isEmpty()) {
                queue = tmp;
                tmp = new ArrayDeque<>();
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeLinkNode tree = new TreeLinkNode(1,
                new TreeLinkNode(2,
                        new TreeLinkNode(4),
                        new TreeLinkNode(5)),
                new TreeLinkNode(3));

        s.connect(tree);

    }
}
