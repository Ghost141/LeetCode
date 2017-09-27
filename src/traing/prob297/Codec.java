package traing.prob297;

import traing.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * Serialize and Deserialize Binary Tree
 * Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/26/17
 */
public class Codec {

    private static final String NIL = "#";
    private static final String SPLITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        transform(root, builder);
        return builder.toString();
    }

    private void transform(TreeNode root, StringBuilder builder) {
        if (root == null) builder.append(NIL).append(SPLITER);
        else {
            builder.append(root.val).append(SPLITER);
            transform(root.left, builder);
            transform(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(data.split(SPLITER)));
        return parse(queue);
    }

    private TreeNode parse(Deque<String> queue) {
        String str = queue.poll();
        if (str.equals(NIL)) return null;
        else {
            TreeNode root = new TreeNode(Integer.valueOf(str));
            root.left = parse(queue);
            root.right = parse(queue);
            return root;
        }
    }

    public static void main(String[] args) {
        Codec c = new Codec();

        System.out.println(c.serialize(new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(1),
                        null),
                new TreeNode(4))));
        String serialize = c.serialize(new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4,
                                        null, new TreeNode(5))))));
        System.out.println(serialize);

        System.out.println(c.deserialize(serialize));
    }
}
