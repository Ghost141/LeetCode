package traing.prob744;

/**
 * Find Smallest Letter Greater Than Target
 * Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/10/17
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (n == 0) return target;
        if (target >= letters[n - 1]) target = letters[0];
        else target++;

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) return letters[mid];
            else if (letters[mid] > target) right = mid;
            else left = mid + 1;
        }
        return letters[right];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }
}
