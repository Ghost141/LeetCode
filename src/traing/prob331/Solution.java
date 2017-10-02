package traing.prob331;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Verify Preorder Serialization of a Binary Tree
 * Link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        return indegreeOutdegreeSolution(preorder);
    }

    private boolean stackSolution(String preorder) {
        String[] nodes = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for (String node : nodes) {
            while (node.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    private boolean indegreeOutdegreeSolution(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.stackSolution("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
