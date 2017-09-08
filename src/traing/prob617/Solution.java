package traing.prob617;

import traing.common.TreeNode;

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        } else {
            final TreeNode res = new TreeNode(t1.val + t2.val);
            res.left = this.mergeTrees(t1.left, t2.left);
            res.right = this.mergeTrees(t1.right, t2.right);

            return res;
        }
    }
}
