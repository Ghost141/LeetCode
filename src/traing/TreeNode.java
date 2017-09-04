package traing;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode (int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.val);
        if (this.left != null) stringBuilder.append("(").append(this.left).append(")");
        if (this.right != null) stringBuilder.append("(").append(this.right).append(")");
        return stringBuilder.toString();
    }
}
