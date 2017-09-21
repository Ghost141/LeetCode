package traing.prob211;

import java.util.HashSet;
import java.util.Set;

/**
 * Add and Search Word - Data structure design
 * Link: https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/21/17
 */
public class WordDictionary {
    private Node root = new Node();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int start, Node node) {
        if (node == null) return false;
        if (start == word.length()) return node.isEnd();
        char c = word.charAt(start);
        if (c == '.') {
            for (Character key : node.keys) {
                Node nextNode = node.get(key);
                if (search(word, start + 1, nextNode)) return true;
            }
            return false;
        } else {
            Node nextNode = node.get(c);
            return search(word, start + 1, nextNode);
        }
    }

    class Node {
        private Node[] links = new Node[26];
        private Set<Character> keys = new HashSet<>();
        private boolean isEnd = false;

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public Node get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, Node node) {
            links[c - 'a'] = node;
            keys.add(c);
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();

        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

//        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));
        System.out.println(dict.search("b.d"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search("ba."));
        System.out.println(dict.search("bc."));
        System.out.println(dict.search("bc."));
    }
}
