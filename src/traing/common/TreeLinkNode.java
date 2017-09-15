package traing.common;

/**
 * The public tree link node class.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/8/17
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    public TreeLinkNode(int x, TreeLinkNode left, TreeLinkNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
