package traing.prob206;

import traing.ListNode;

/**
 * Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
