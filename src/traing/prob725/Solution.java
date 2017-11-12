package traing.prob725;

import traing.common.ListNode;

/**
 * Split Linked List in Parts
 * Link: https://leetcode.com/problems/split-linked-list-in-parts/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/13/17
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode head = root;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        int mod = len % k;
        int subLen = len / k;
        ListNode[] res = new ListNode[k];
        for (int ind = 0; ind < k; ind++) {
            ListNode fakeHead = new ListNode(-1);
            ListNode last = new ListNode(-1);
            fakeHead.next = root;
            for (int j = 0; j < subLen; j++) {
                last = root;
                root = root.next;
            }
            if (mod-- > 0) {
                last = root;
                root = root.next;
            }
            last.next = null;
            res[ind] = fakeHead.next;
        }
        return res;
    }
}
