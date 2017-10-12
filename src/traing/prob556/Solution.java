package traing.prob556;

/**
 * Next Greater Element III
 * Link: https://leetcode.com/problems/next-greater-element-iii/solution/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/12/17
 */
public class Solution {
    public int nextGreaterElement(int n) {
        char[] num = Integer.toString(n).toCharArray();
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) i--;
        if (i >= 0) {
            int j = num.length - 1;
            while (j > i && num[j] <= num[i]) j--;
            swap(num, i, j);
            reverse(num, i + 1, num.length - 1);
            if (isValid(num)) return Integer.valueOf(String.valueOf(num));
            else return -1;
        } else return -1;
    }

    private boolean isValid(char[] num) {
        char[] max = Integer.toString(Integer.MAX_VALUE).toCharArray();
        if (num.length < max.length) return true;
        else {
            for (int i = 0; i < max.length; i++) {
                if (num[i] < max[i]) return true;
                else if (num[i] > max[i]) return false;
            }
            return true;
        }
    }

    private void swap(char[] num, int i, int j) {
        char c = num[i];
        num[i] = num[j];
        num[j] = c;
    }

    private void reverse(char[] num, int start, int end) {
        while (start < end) swap(num, start++, end--);
    }
}
