package traing.prob520;

public class Solution {
    public boolean detectCapitalUse(String word) {
        final boolean firstCapital = isCapital(word.charAt(0));
        final String substring = word.substring(1);
        return firstCapital ? allSame(substring, 1) || allSame(substring, 0) : allSame(substring, 0);
    }

    private boolean isCapital(char c) {
        final int diff = c - 65;
        return diff >= 0 && diff < 26;
    }

    private boolean allSame(String word, int isUpper) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int allUpper = 1;
        int allLower = 1;
        for (int i = 0; i < word.length(); i++) {
            if (isCapital(word.charAt(i))) {
                // upper case.
                allLower = 0;
            } else {
                allUpper = 0;
            }
        }
        if ((allUpper ^ allLower) == 1) {
            return isUpper == allUpper;
        }
        return false;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
//        System.out.println(s.detectCapitalUse("Hello"));
        System.out.println(s.detectCapitalUse("hello"));
        System.out.println(s.detectCapitalUse("w"));
        System.out.println(s.detectCapitalUse("W"));
        System.out.println(s.detectCapitalUse("WWW"));
        System.out.println(s.detectCapitalUse("WWwW"));
        System.out.println(s.detectCapitalUse("WWWw"));
        System.out.println(s.detectCapitalUse("wWWW"));
        System.out.println(s.detectCapitalUse("GoogleW"));

    }
}
