package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author zhaokai
 */
public class Combination {
    private String[] str = { "a", "b", "c" };

    int n = str.length;

    int nBit = 1 << n;

    public List<List<String>> combination() {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < nBit; i++) {
            List<String> res = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j;
                if ((tmp & i) != 0) {
                    res.add(str[j]);
                }
            }
            result.add(res);
        }

        return result;
    }

    public static void main(String[] args) {
        final Combination c = new Combination();

        System.out.println(c.combination());
    }
}
