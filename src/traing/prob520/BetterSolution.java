package traing.prob520;

public class BetterSolution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            count += isCapital(c);
        }
        return count == 0 || count == word.length() || count == 1 && isCapital(word.charAt(0)) == 1;
    }

    private int isCapital(char c) {
        final int diff = c - 65;
        if (diff >= 0 && diff < 26) {
            return 1;
        } else {
            return 0;
        }
    }

}
