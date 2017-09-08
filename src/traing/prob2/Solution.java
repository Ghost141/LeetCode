package traing.prob2;

import traing.common.ListNode;

/**
 * Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers/description/
 *
 * @author zhaokai
 * @version 1.1
 * @since 1.1 - 8/9/17
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode tmp = fakeHead;

        int acc = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            tmp.next = new ListNode((v1 + v2 + acc) % 10);
            tmp = tmp.next;
            acc = (v1 + v2 + acc) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (acc >= 1) {
            tmp.next = new ListNode(acc);
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
