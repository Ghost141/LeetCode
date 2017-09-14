package traing.prob71;

import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Simplify Path
 * Link: https://leetcode.com/problems/simplify-path/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.isEmpty()) continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else if (!str.equals(".")) stack.push(str);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append("/").append(stack.pollLast());
        return builder.length() == 0 ? "/" : builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/.."));
        System.out.println(s.simplifyPath("/a/b/d"));
    }
}
