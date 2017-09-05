package traing.prob249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Shifted Strings
 * Link: https://leetcode.com/problems/group-shifted-strings/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/5/17
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuilder keyBuilder = new StringBuilder();
            String key;
            if (s.length() == 1) {
                key = "0";
            } else {
                for (int i = 1; i < s.length(); i++) {
                    char c1 = s.charAt(i);
                    char c0 = s.charAt(i - 1);
                    int tmp = c1 - c0 < 0 ? c1 - c0 + 26 : c1 - c0;
                    keyBuilder.append(tmp).append(".");
                }
                key = keyBuilder.toString();
            }
            List<String> val = map.getOrDefault(key, new ArrayList<>());
            val.add(s);
            map.put(key, val);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}
