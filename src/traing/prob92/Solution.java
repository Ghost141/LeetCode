package traing.prob92;

import traing.common.ListNode;

/**
 * Reverse Linked List II
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        for (int i = 0; i < m - 1; i++) prev = prev.next;
        ListNode start = prev.next, then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return fakeHead.next;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverseBetween(new ListNode(3, new ListNode(5)), 1, 1));
    }
}
