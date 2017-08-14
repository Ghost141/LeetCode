package traing.prob173;

import traing.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Binary Search Tree Iterator
 * Link: https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class BSTIterator {
    private Deque<TreeNode> nodeStack;
    public BSTIterator(TreeNode root) {
        this.nodeStack = new ArrayDeque<>();
        while (root != null) {
            this.nodeStack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.nodeStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = this.nodeStack.pop(), tmp = node;

        if (tmp.right != null) {
            tmp = node.right;
            while (tmp != null) {
                this.nodeStack.push(tmp);
                if (tmp.left != null) {
                    tmp = tmp.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
    }

    public static void main(String[] args) {
        BSTIterator it = new BSTIterator(new TreeNode(1, null, new TreeNode(2)));
//        BSTIterator it = new BSTIterator(new TreeNode(2, new TreeNode(1), null));

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
