package traing.prob271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Encode and Decode Strings
 * Link: https://leetcode.com/problems/encode-and-decode-strings/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) res.append(str.length()).append("/").append(str);
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int ind = 0;
        while (ind < s.length()) {
            int slash = s.indexOf("/", ind);
            int len = Integer.valueOf(s.substring(ind, slash));
            res.add(s.substring(slash + 1, slash + 1 + len));
            ind = slash + len + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Codec s = new Codec();
        System.out.println(s.decode(s.encode(Arrays.asList("", ""))));
    }
}
