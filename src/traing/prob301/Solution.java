package traing.prob301;

import java.util.*;

/**
 * Remove Invalid Parentheses
 * Link: https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/8/17
 */
public class Solution {
//    // The solution below is based on this discussion: https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> res = new ArrayList<>();
//        remove(s, res, 0, 0, new char[] {'(', ')'});
//        return res;
//    }
//
//    private void remove(String s, List<String> list, int start, int lastInd, char[] chars) {
//        int count = 0;
//        for (int i = start; i < s.length(); i++) {
//            if (s.charAt(i) == chars[0]) count++;
//            else if (s.charAt(i) == chars[1]) count--;
//            if (count >= 0) continue;
//            for (int j = lastInd; j <= i; j++) {
//                if (s.charAt(j) == chars[1] && (j == lastInd || s.charAt(j - 1) != chars[1])) {
//                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), list, i, j, chars);
//                }
//            }
//            return;
//        }
//        // Remove reversed.
//        String reversed = new StringBuilder(s).reverse().toString();
//
//        if (chars[0] == '(') remove(reversed, list, 0, 0, new char[]{')', '('});
//        else list.add(reversed);
//    }

    public List<String> removeInvalidParentheses(String s) {
        Deque<String> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        if (s == null) return res;

        boolean stop = false;

        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isValidParentheses(str)) {
                res.add(str);
                stop = true;
            }
            if (stop) continue;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                String nextStr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(nextStr)) {
                    queue.add(nextStr);
                    visited.add(nextStr);
                }
            }
        }
        return res;
    }

    private boolean isValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeInvalidParentheses(")d))"));
    }

}
