package traing.prob449;

import traing.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Serialize and Deserialize BST
 * Link: https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/19/17
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        ser(root, builder);
        return builder.toString();
    }

    private void ser(TreeNode node, StringBuilder builder) {
        if (node == null) builder.append("#").append(",");
        else {
            builder.append(node.val).append(",");
            ser(node.left, builder);
            ser(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue =new ArrayDeque<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return parse(queue);
    }
    private TreeNode parse(Deque<String> queue) {
        String str = queue.poll();
        if (str.equals("#")) return null;
        else {
            TreeNode root = new TreeNode(Integer.valueOf(str));
            root.left = parse(queue);
            root.right = parse(queue);
            return root;
        }
    }

    public static void main(String[] args) {
        Codec s = new Codec();

        System.out.println(s.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }
}
