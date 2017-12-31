package traing.prob752;

import java.util.*;

/**
 * Open the Lock
 * Link: https://leetcode.com/problems/open-the-lock/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 31/12/2017
 */
public class Solution {
    private static char next(char c) {
        if (c < '9') return ++c;
        return '0';
    }

    private static char prev(char c) {
        if (c == '0') return '9';
        return --c;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);
        visited.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            String val = queue.poll();
            if (val == null) {
                depth++;
                if (!queue.isEmpty() && queue.peek() != null) queue.offer(null);
            } else if (deadSet.contains(val)) return -1;
            else if (val.equals(target)) return depth;
            else {
                char[] chars = val.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char origin = chars[i];
                    chars[i] = next(origin);
                    String n = new String(chars);
                    if (!visited.contains(n) && !deadSet.contains(n)) {
                        visited.add(n);
                        queue.offer(n);
                    }
                    chars[i] = prev(origin);
                    String p = new String(chars);
                    if (!visited.contains(p) && !deadSet.contains(p)) {
                        visited.add(p);
                        queue.offer(p);
                    }

                    chars[i] = origin;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.openLock("0201,0101,0102,1212,2002".split(","), "0202"));
//        System.out.println(s.openLock("0000".split(","), "8888"));
    }
}
