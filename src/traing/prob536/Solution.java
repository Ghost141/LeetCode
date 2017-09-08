package traing.prob536;

import traing.common.TreeNode;

/**
 * Construct Binary Tree from String
 * Link: https://leetcode.com/problems/construct-binary-tree-from-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public TreeNode str2tree(String s) {
        return build(s, new int[] {0});
    }
    private TreeNode build(String s, int[] start) {
        TreeNode root = null;
        boolean isNegative = false;
        while (start[0] < s.length()) {
            char c = s.charAt(start[0]);
            if (Character.isDigit(c) || c == '-') {
                if (c == '-') {
                    isNegative = true;
                } else {
                    if (root == null) {
                        root = new TreeNode(isNegative ? (c - '0') * -1 : (c - '0'));
                    } else {
                        root.val = root.val * 10 + (isNegative ? (c - '0') * -1 : (c - '0'));
                    }
                }
                start[0]++;
            } else {
                if (c == '(') {
                    start[0]++;
                    root.left = build(s, start);
                    if (start[0] < s.length() && s.charAt(start[0]) == '(') {
                        start[0]++;
                        root.right = build(s, start);
                    }
                } else if (c == ')') {
                    start[0]++;
                    return root;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.str2tree("4(3)"));
        System.out.println(s.str2tree("4(3)(2)"));
        System.out.println(s.str2tree("4"));
        System.out.println(s.str2tree("4(3(5)(6))(2(10))"));
        System.out.println(s.str2tree("-4"));
        System.out.println(s.str2tree("-40"));
        System.out.println(s.str2tree("-40(1)"));
        System.out.println(s.str2tree("-40(1)(-2)"));
    }
}
