package traing.prob160;

import traing.ListNode;

/**
 * Intersection of Two Linked Lists
 *
 * @author zhaokai
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

}
