package traing.prob17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> ans = new LinkedList<>();
        ans.add("");

        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i) {
                String s = ans.remove();
                for (char c : mapping[x].toCharArray()) {
                    ans.add(s + c);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.letterCombinations("2"));
    }
}
