package traing.prob206;

import traing.common.ListNode;

/**
 * Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Use Recursive solution to solve this problem.
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
