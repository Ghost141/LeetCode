package traing.prob3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        String longString = "";
        String finalString = "";

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            final int ind = longString.indexOf(c);
            if (ind >= 0) {
                longString = longString.substring(ind + 1) + c;
            } else {
                longString += c;
                if (finalString.length() < longString.length()) {
                    finalString = longString;
                }
            }
        }
        return finalString.length();
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("aab"));
        System.out.println(s.lengthOfLongestSubstring("abb"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
        System.out.println(s.lengthOfLongestSubstring("a"));
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(s.lengthOfLongestSubstring("bbbbbbb"));
    }
}
