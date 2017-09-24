package traing.prob677;

/**
 * Map Sum Pairs
 * Link: https://leetcode.com/problems/map-sum-pairs/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/24/17
 */
public class MapSum {

    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int ind = c - 'a';
            if (node.nodes[ind] == null) {
                node.nodes[ind] = new TrieNode();
            }
            node = node.nodes[ind];
        }
        node.value = val;
    }

    public int sum(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int ind = c - 'a';
            node = node.nodes[ind];
            if (node == null) return 0;
        }
        return _sum(node);
    }

    private int _sum(TrieNode root) {
        int sum = root.value;
        for (TrieNode node : root.nodes) {
            if (node != null) sum += _sum(node);
        }
        return sum;
    }

    class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];
        private int value = 0;

        public TrieNode() {
        }
    }

    public static void main(String[] args) {
        MapSum s = new MapSum();

        s.insert("a", 3);
        System.out.println(s.sum("ap"));
        s.insert("b", 2);
        System.out.println(s.sum("a"));
    }
}
