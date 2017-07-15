package traing.prob14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int ind = 0;
        String firstString = strs[0];

        while (true) {
            boolean res = true;
            for (String str : strs) {
                if (ind == str.length() || firstString.length() == ind) {
                    res = false;
                    break;
                }
                res = res && str.charAt(ind) == firstString.charAt(ind);
            }
            if (!res) {
                break;
            }
            ind++;
        }

        return firstString.substring(0, ind);
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
