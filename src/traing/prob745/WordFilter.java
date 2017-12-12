package traing.prob745;

import java.util.*;

/**
 * Prefix and Suffix Search
 * Link: https://leetcode.com/problems/prefix-and-suffix-search/description/
 *
 * @author zhaokai
 * @version 1.0 Trie with intersection set solution. It can be improved.
 * @since 1.0 - 12/10/17
 */
public class WordFilter {
    private Node root = new Node();
    private Node reverseRoot = new Node();
    private Map<String, Integer> allWords = new HashMap<>();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node node = this.root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (node.nodes[c - 'a'] == null) node.nodes[c - 'a'] = new Node();
                node = node.nodes[c - 'a'];
            }
            node.word = word;
            node.weight = i;

            node = this.reverseRoot;
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                if (node.nodes[c - 'a'] == null) node.nodes[c - 'a'] = new Node();
                node = node.nodes[c - 'a'];
            }
            node.word = word;
            node.weight = i;

            allWords.put(word, i);
        }
    }

    public int f(String prefix, String suffix) {
        Node node = this.root;
        Map<String, Integer> map = new HashMap<>();
        if (prefix.length() == 0) {
            map = allWords;
        } else {
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.nodes[c - 'a'] == null) return -1;
                if (node.nodes[c - 'a'].word != null) map.put(node.nodes[c - 'a'].word, node.nodes[c - 'a'].weight);
                node = node.nodes[c - 'a'];
            }
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                for (Node next : poll.nodes) {
                    if (next != null) {
                        queue.offer(next);
                        if (next.word != null) map.put(next.word, next.weight);
                    }
                }
            }
        }

        node = this.reverseRoot;
        if (suffix.length() == 0) {
            int max = -1;
            for (Integer integer : map.values()) max = Math.max(max, integer);
            return max;
        } else {
            int max = -1;
            for (int i = suffix.length() - 1; i >= 0; i--) {
                char c = suffix.charAt(i);
                if (node.nodes[c - 'a'] == null) return -1;
                if (node.nodes[c - 'a'].word != null && map.containsKey(node.nodes[c - 'a'].word)) {
                    max = Math.max(max, node.nodes[c - 'a'].weight);
                }
                node = node.nodes[c - 'a'];
            }
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                for (Node next : poll.nodes) {
                    if (next != null) {
                        queue.offer(next);
                        if (next.word != null && map.containsKey(next.word)) max = Math.max(max, next.weight);
                    }
                }
            }
            return max;
        }
    }

    class Node {
        Node[] nodes = new Node[26];
        String word = null;
        int weight = 0;

        public Node() {
        }
    }

    public static void main(String[] args) {
        WordFilter s = new WordFilter(new String[]{"apple"});

        System.out.println(s.f("a", "e"));
        System.out.println(s.f("app", "e"));
        System.out.println(s.f("apple", "ple"));
        System.out.println(s.f("a", "e"));
        System.out.println(s.f("b", ""));
    }
}
