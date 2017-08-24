package algorithm.dp;

/**
 * LCS(Longest Common Subsequence)
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class LCS {
    public String lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] arr = new int[len1 + 1][len2 + 1];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else if (arr[i + 1][j] >= arr[i][j + 1]) i++;
            else j++;
        }
        return sb.toString();
    }
}
