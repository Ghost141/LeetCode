package traing.prob408;

/**
 * Valid Word Abbreviation
 * Link: https://leetcode.com/problems/valid-word-abbreviation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wi = 0, abi = 0;
        int jump = 0;
        while (wi < word.length() && abi < abbr.length()) {
            if (word.charAt(wi) == abbr.charAt(abi)) {
                wi++;
                abi++;
                continue;
            }
            if (!Character.isDigit(abbr.charAt(abi)) || abbr.charAt(abi) == '0') return false;
            if (Character.isDigit(abbr.charAt(abi))) {
                int start = abi;
                while (abi < abbr.length() && Character.isDigit(abbr.charAt(abi))) abi++;
                jump = Integer.valueOf(abbr.substring(start, abi));
                wi += jump;
            }
        }
        return wi == word.length() && abi == abbr.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.validWordAbbreviation("apple", "a2e"));
        System.out.println(s.validWordAbbreviation("aaaa", "a2"));
    }
}
