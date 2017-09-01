package traing.prob93;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Address
 * Link: https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", s, 0, 0);
        return list;
    }

    private void backtrack(List<String> list, String tmpIP, String str, int start, int count) {
        if (tmpIP.length() == str.length() + 3) list.add(tmpIP);
        else if (count >= 4) return;
        else {
            for (int i = start; i < start + 3 && i < str.length(); i++) {
                String ipStr = str.substring(start, i + 1);
                Integer ip = Integer.valueOf(ipStr);
                if (ip >= 0 && ip <= 255) {
                    if ((ip == 0 && !ipStr.equals("0")) || (ip != 0 && ipStr.substring(0, 1).equals("0"))) continue;
                    String next = tmpIP.length() == 0 ? ipStr : tmpIP + "." + ipStr;
                    backtrack(list, next, str, i + 1, count + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.restoreIpAddresses("25525511135"));
        System.out.println(s.restoreIpAddresses("010010"));
    }
}
