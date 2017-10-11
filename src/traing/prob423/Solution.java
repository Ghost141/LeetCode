package traing.prob423;

/**
 * Reconstruct Original Digits from English
 * Link: https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/11/17
 */
public class Solution {
    private static final int F = 5;
    private static final int G = 6;
    private static final int I = 8;
    private static final int N = 13;
    private static final int O = 14;
    private static final int S = 18;
    private static final int T = 19;
    private static final int U = 20;
    private static final int W = 22;
    private static final int X = 23;
    private static final int Z = 25;
    public String originalDigits(String s) {
        int[] count = new int[26];
        int[] num = new int[10];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        find(count, num);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            while (num[i]-- > 0) builder.append(i);
        }

        return builder.toString();
    }

    private void find(int[] count, int[] num) {
        if (count[Z] > 0) {
            num[0] += count[Z];
            count[O] -= count[Z];
        }
        if (count[W] > 0) {
            num[2] += count[W];
            count[T] -= count[W];
            count[O] -= count[W];
        }
        if (count[U] > 0) {
            num[4] += count[U];
            count[F] -= count[U];
            count[O] -= count[U];
        }
        if (count[X] > 0) {
            num[6] += count[X];
            count[S] -= count[X];
            count[I] -= count[X];
        }
        if (count[G] > 0) {
            num[8] += count[G];
            count[T] -= count[G];
            count[I] -= count[G];
        }
        if (count[S] > 0) {
            num[7] += count[S];
            count[N] -= count[S];
        }
        if (count[O] > 0) {
            num[1] += count[O];
            count[N] -= count[O];
        }
        num[3] += count[T];
        num[5] += count[F];
        count[I] -= count[F];
        num[9] += count[I];
    }

    public static void main(String[] args) {
        System.out.println('u' - 'a');
        System.out.println('t' - 'a');
    }
}
