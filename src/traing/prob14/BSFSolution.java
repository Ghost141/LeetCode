package traing.prob14;

public class BSFSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());

        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix (String[] strs, int position) {
        final String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(s.substring(0, position))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final BSFSolution s = new BSFSolution();

        System.out.println(s.longestCommonPrefix(new String[] {"a", "ab"}));
    }
}
