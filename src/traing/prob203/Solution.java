package traing.prob203;

import traing.ListNode;

/**
 * Remove Linked List Elements
 * Link: https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
