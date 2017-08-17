package algorithm.tree;

import traing.TreeNode;

/**
 * Binary Search Tree(BST) builder.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class BSTBuilder {
    public TreeNode buildFromSortedArray(int[] data) {
        return createBST(data, 0, data.length - 1);
    }

    private TreeNode createBST(int[] data, int start, int end) {
        if (end < start) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(data[mid]);
        node.left = createBST(data, start, mid - 1);
        node.right = createBST(data, mid + 1, end);
        return node;
    }
}
