package traing.prob604;

/**
 * Design Compressed String Iterator
 * Link: https://leetcode.com/problems/design-compressed-string-iterator/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/7/17
 */
public class StringIterator {
    private String str;
    private char _next;
    private int count = 0;
    private int ind = 0;
    public StringIterator(String compressedString) {
        str = compressedString;
    }

    public char next() {
        if (hasNext()) {
            count--;
            return _next;
        } else return ' ';
    }

    public boolean hasNext() {
        if (this.count > 0) return true;
        if (ind == str.length()) return false;
        _next = str.charAt(ind++);
        int number = 0;
        while (ind < str.length() && Character.isDigit(str.charAt(ind))) {
            char c = str.charAt(ind++);
            number = number * 10 + (c - '0');
        }
        count = number;
        return true;
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

        System.out.println(iterator.next());; // return 'L'
        System.out.println(iterator.next());; // return 'e'
        System.out.println(iterator.next());; // return 'e'
        System.out.println(iterator.next());; // return 't'
        System.out.println(iterator.next());; // return 'C'
        System.out.println(iterator.next());; // return 'o'
        System.out.println(iterator.next());; // return 'd'
        System.out.println(iterator.hasNext());; // return true
        System.out.println(iterator.next());; // return 'e'
        System.out.println(iterator.hasNext());; // return false
        System.out.println(iterator.next());; // return ' '
    }
}
