package traing.prob9;

public class BetterSolution {
    private int reverse = 0;

    public boolean isPalindrome(int x) {
        boolean result = false;
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;

            if (reverse == x || reverse / 10 == x) {
                result = true;
            }
        }

        return result;
    }
}
