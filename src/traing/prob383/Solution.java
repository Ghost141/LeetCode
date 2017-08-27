package traing.prob383;

/**
 * Ransom Note
 * Link: https://leetcode.com/problems/ransom-note/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/27/17
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[256];

        for (int i = 0; i < magazine.length(); i++) count[magazine.charAt(i)]++;
        for (int i = 0; i < ransomNote.length(); i++)
            if (--count[ransomNote.charAt(i)] < 0) return false;
        return true;
    }
}
