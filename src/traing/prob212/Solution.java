package traing.prob212;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Search II
 * Link: https://leetcode.com/problems/word-search-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/21/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (String word : words) buildTrie(root, word);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                TrieNode nextNode = root.nodes[c - 'a'];
                if (nextNode != null) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    checkWord(res, nextNode);
                    helper(i, j, board, visited, nextNode, res);
                }
            }
        }
        return res;
    }

    private void checkWord(List<String> res, TrieNode node) {
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
    }

    private void helper(int row, int col, char[][] board, boolean[][] visited, TrieNode node, List<String> res) {
        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                char c = board[x][y];
                TrieNode nextNode = node.nodes[c - 'a'];
                if (nextNode != null) {
                    visited[x][y] = true;
                    checkWord(res, nextNode);
                    helper(x, y, board, visited, nextNode, res);
                    visited[x][y] = false;
                }
            }
        }
    }

    private void buildTrie(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TrieNode();
            }
            node = node.nodes[c - 'a'];
        }
        node.word = word;
    }

    class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];
        private String word = null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.findWords(DataGenerator.createCharBoard("ab|cd"), new String[]{"acdb"}));
        System.out.println(s.findWords(DataGenerator.createCharBoard("abc|aed|afg"), new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"}));
    }
}
