package traing.prob143;

import traing.common.ListNode;

/**
 * Reorder List
 * Link: https://leetcode.com/problems/reorder-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middle = slow;
        ListNode prevCurrent = slow.next;
        while (prevCurrent.next != null) {
            ListNode current = prevCurrent.next;
            prevCurrent.next = current.next;
            current.next = middle.next;
            middle.next = current;
        }
        ListNode node1 = head;
        ListNode node2 = middle.next;
        while (node1 != middle) {
            middle.next = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node1 = node2.next;
            node2 = middle.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        s.reorderList(head);
        System.out.println(head);
    }
}
