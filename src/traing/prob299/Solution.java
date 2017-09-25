package traing.prob299;

import java.util.HashMap;
import java.util.Map;

/**
 * Bulls and Cows
 * Link: https://leetcode.com/problems/bulls-and-cows/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) A++;
            else {
                secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
                guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : guessMap.entrySet())
            if (secretMap.containsKey(entry.getKey())) B += Math.min(secretMap.get(entry.getKey()), entry.getValue());
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getHint("1123", "0111"));
    }
}
