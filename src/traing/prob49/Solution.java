package traing.prob49;

import java.util.*;

/**
 * Group Anagrams
 * Link: https://leetcode.com/problems/group-anagrams/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/5/17
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
