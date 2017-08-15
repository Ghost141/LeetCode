package traing.prob379;

/**
 * Design Phone Directory
 * Link: https://leetcode.com/problems/design-phone-directory/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class PhoneDirectory {

    private int[] book;
    private int next = 0;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        book = new int[maxNumbers];
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (next == book.length) return -1;
        book[next] = 1;
        int res = next;

        while (next < book.length && book[next] != 0) {
            next++;
        }
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return book[number] == 0;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        next = Math.min(next, number);
        book[number] = 0;
    }

    public static void main(String[] args) {
        PhoneDirectory d = new PhoneDirectory(4);

        System.out.println(d.get());
        System.out.println(d.get());
        System.out.println(d.get());
        d.release(2);
        d.release(0);
        System.out.println(d.get());
        System.out.println(d.get());
    }
}