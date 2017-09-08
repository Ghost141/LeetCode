package traing.prob103;

import traing.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Zigzag Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/6/17
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> tmp = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        boolean fromLeft = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);

            if (fromLeft) {
                if (node.left != null) tmp.push(node.left);
                if (node.right != null) tmp.push(node.right);
            } else {
                if (node.right != null) tmp.push(node.right);
                if (node.left != null) tmp.push(node.left);
            }
            if (queue.isEmpty()) {
                fromLeft = !fromLeft;
                queue = tmp;
                tmp = new ArrayDeque<>();
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.zigzagLevelOrder(new TreeNode(3,
//                new TreeNode(9),
//                new TreeNode(20, new TreeNode(15), new TreeNode(7)))
//        ));
        System.out.println(s.zigzagLevelOrder(
//                new TreeNode(1,
//                        new TreeNode(2, new TreeNode(4), null),
//                        new TreeNode(3, null, new TreeNode(5)))
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8), new TreeNode(9)),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6,
                                        new TreeNode(10), new TreeNode(11)),
                                new TreeNode(7)))
        ));
    }
}
