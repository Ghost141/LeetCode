package interview.airbnb;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Remove duplicate letter from given string and return the least result.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/27/17
 */
public class RemoveDuplicateLetter {
    public String removeDuplicateLetter(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (!visited[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 1) {
                    visited[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                visited[c - 'a'] = true;
            }
        }
        char[] res = new char[stack.size()];
        int ind = stack.size() - 1;
        while (!stack.isEmpty()) res[ind--] = stack.pop();
        return new String(res);
    }
}
