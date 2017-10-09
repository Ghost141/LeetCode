package traing.prob358;

import java.util.*;

/**
 * Rearrange String k Distance Apart
 * Link: https://leetcode.com/problems/rearrange-string-k-distance-apart/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    public String rearrangeString(String s, int k) {
        StringBuilder builder = new StringBuilder();
        Map<Character, Char> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.computeIfAbsent(s.charAt(i), Char::new).count++;

        PriorityQueue<Char> queue = new PriorityQueue<>(new Comparator<Char>() {
            @Override
            public int compare(Char o1, Char o2) {
                return -Integer.compare(o1.count, o2.count);
            }
        });
        Deque<Char> wait = new ArrayDeque<>();
        queue.addAll(map.values());

        while (!queue.isEmpty()) {
            Char current = queue.poll();
            builder.append(current.c);
            current.count--;
            wait.offer(current);
            if (wait.size() < k) continue;
            Char oldest = wait.poll();
            if (oldest.count > 0) queue.offer(oldest);
        }
        // achieve
        return builder.length() == s.length() ? builder.toString() : "";
    }

    class Char {
        char c;
        int count;

        public Char(char c) {
            this.c = c;
            this.count = 0;
        }
    }
}
