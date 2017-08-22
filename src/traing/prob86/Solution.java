package traing.prob86;

import traing.ListNode;

/**
 * Partition List
 * Link: https://leetcode.com/problems/partition-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode fl = new ListNode(0), fr = new ListNode(0), l = fl, r = fr;

        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = head;
            } else {
                r.next = head;
                r = head;
            }

            head = head.next;
        }
        r.next = null;
        l.next = fr.next;
        return fl.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.partition(new ListNode(2, new ListNode(1)), 2));
    }
}
