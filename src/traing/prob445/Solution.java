package traing.prob445;

import traing.ListNode;

/**
 * Add Two Numbers II
 * Link: https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/9/17
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);
        int max = Math.max(len1, len2);
        int offset = Math.abs(len2 - len1);

        ListNode result = len1 == max ? recursiveAdd(l1, l2, offset) : recursiveAdd(l2, l1, offset);

        if (result.val > 9) {
            ListNode tmp = new ListNode(1);
            result.val %= 10;
            tmp.next = result;
            result = tmp;
        }

        return result;
    }

    private int len(ListNode head) {
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) len++;
        return len;
    }

    private ListNode recursiveAdd(ListNode longList, ListNode shortList, int offset) {
        if (longList == null) return null;
        ListNode node = offset == 0 ? new ListNode(longList.val + shortList.val) : new ListNode(longList.val);
        node.next = offset == 0 ? recursiveAdd(longList.next, shortList.next, 0) : recursiveAdd(longList.next, shortList, offset - 1);

        if (node.next != null && node.next.val > 9) {
            node.val += 1;
            node.next.val = node.next.val % 10;
        }
        return node;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        ListNode l14 = new ListNode(0);
//        ListNode l13 = new ListNode(0, l14);
//        ListNode l12 = new ListNode(2, l13);
//        ListNode l11 = new ListNode(1, l12);
        ListNode l13 = new ListNode(0);
        ListNode l12 = new ListNode(9, l13);
        ListNode l11 = new ListNode(9, l12);

//        ListNode l24 = new ListNode(0);
//        ListNode l23 = new ListNode(3, l24);
//        ListNode l22 = new ListNode(2, l23);
//        ListNode l21 = new ListNode(9, l22);
        ListNode l22 = new ListNode(9);
        ListNode l21 = new ListNode(8, l22);


        System.out.println(s.addTwoNumbers(l11, l21));
    }
}
