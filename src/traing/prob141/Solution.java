package traing.prob141;

import traing.ListNode;

/**
 * Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head.next, fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hasCycle(new ListNode(1, new ListNode(2))));
    }
}
