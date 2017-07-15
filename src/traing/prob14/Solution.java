package traing.prob14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String firstString = strs[0];

        for (int i = 0; i < firstString.length(); i++) {
            final char c = firstString.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                final String strJ = strs[j];
                if (i >= strJ.length() || strJ.charAt(i) != c) return firstString.substring(0, i);
            }
        }
        return firstString;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.longestCommonPrefix(new String[] {"a", "b"}));
        System.out.println(s.longestCommonPrefix(new String[] {"a", "ab"}));
        System.out.println(s.longestCommonPrefix(new String[] {"ab", "ab"}));
        System.out.println(s.longestCommonPrefix(new String[] {"abc", "ab"}));
        System.out.println(s.longestCommonPrefix(new String[] {"b", "ab"}));
    }
}
