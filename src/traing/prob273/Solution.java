package traing.prob273;

import java.util.HashMap;
import java.util.Map;

/**
 * Integer to English Words
 * Link: https://leetcode.com/problems/integer-to-english-words/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/20/17
 */
public class Solution {
    private static final String[] LESS_THAN_TWENTY = new String[]{
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve"
            , "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] BIGGER_THAN_TWENTY = new String[]{
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] DIGIT = new String[]{
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String word = "";
        int digitCount = 0;

        while (num != 0) {
            if (num % 1000 != 0) word = helper(num % 1000) + DIGIT[digitCount] + " " + word;
            digitCount++;
            num /= 1000;
        }

        return word.trim();
    }

    private String helper(int num) {
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_TWENTY[num] + " ";
        else if (num < 100) return BIGGER_THAN_TWENTY[num / 10] + " " + helper(num % 10);
        else return LESS_THAN_TWENTY[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
