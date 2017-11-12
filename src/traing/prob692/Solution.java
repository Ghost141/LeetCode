package traing.prob692;

import java.util.*;

/**
 * Top K Frequent Words
 * Link: https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordCount> map = new HashMap<>();
        for (String word : words) {
            map.computeIfAbsent(word, (WordCount::new)).count++;
        }
        List<WordCount> list = new ArrayList<>(map.values());
        Collections.sort(list);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(list.get(i).word);
        return res;
    }

    class WordCount implements Comparable<WordCount> {
        String word;
        int count = 0;

        public WordCount(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(WordCount o) {
            return count == o.count ? word.compareTo(o.word) : -Integer.compare(count, o.count);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
