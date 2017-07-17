package traing.prob205;

import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 * @author zhaokai
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> mapBack = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {

            String si = getString(s, i);
            String ti = getString(t, i);
            if (map.containsKey(si)) {
                if (!map.get(si).equals(ti)) {
                    return false;
                }
            } else {
                if (mapBack.containsKey(ti) && !mapBack.get(ti).equals(si)) {
                    return false;
                }
                map.put(si, ti);
                mapBack.put(ti, si);
            }
        }
        return true;
    }

    private String getString(String s, int i) {
        return String.valueOf(s.charAt(i));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isIsomorphic("ab", "aa"));
    }
}
