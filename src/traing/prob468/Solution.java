package traing.prob468;

/**
 * Validate IP Address
 * Link: https://leetcode.com/problems/validate-ip-address/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/12/17
 */
public class Solution {

    private static final String NEITHER = "Neither";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";

    public String validIPAddress(String IP) {
        if (IP.indexOf(".") > 0) return ipV4Checker(IP);
        else if (IP.indexOf(":") > 0) return ipV6Checker(IP);
        else return NEITHER;
    }

    private String ipV4Checker(String IP) {
        String[] group = IP.split("\\.");
        if (IP.endsWith(".")) return NEITHER;
        if (group.length != 4) return NEITHER;
        for (String digit : group) {
            if (digit.length() == 0 || digit.length() > 3 || (digit.length() != 1 && digit.charAt(0) == '0')) return NEITHER;
            int val = 0;
            for (int i = 0; i < digit.length(); i++) {
                char c = digit.charAt(i);
                if (c < '0' || c > '9') return NEITHER;
                val = val * 10 + c - '0';
            }
            if (val < 0 || val > 255) return NEITHER;
        }
        return IPV4;
    }

    private String ipV6Checker(String IP) {
        String[] group = IP.split(":");
        if (IP.endsWith(":")) return NEITHER;
        if (group.length != 8) return NEITHER;
        for (String digit : group) {
            if (digit.length() > 4 || digit.length() == 0) return NEITHER;
            digit = digit.toLowerCase();
            for (int i = 0; i < digit.length(); i++) {
                char c = digit.charAt(i);
                if (c < '0' || c > 'f') return NEITHER;
            }
        }
        return IPV6;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.validIPAddress("1.2.3.4"));
//        System.out.println(s.validIPAddress("1.2.0s.4"));
//        System.out.println(s.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
//        System.out.println(s.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(s.validIPAddress("2001:db8:85a3:::8A2E:0370:7334"));
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

//        System.out.println(s.split("1.2.3.4", '.'));
//        System.out.println(s.split("1.2.3.40", '.'));
//        System.out.println(s.split("1.2.3.40.", '.'));
    }
}
