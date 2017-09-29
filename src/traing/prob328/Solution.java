package traing.prob328;

import traing.common.ListNode;
import utils.DataGenerator;

/**
 * Odd Even Linked List
 * Link: https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/29/17
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        oddHead.next = head;
        evenHead.next = head.next;
        ListNode odd = head, even = head.next;

        while (even != null && even.next != null) {
            ListNode nextOdd = even.next;
            ListNode nextEven = even.next.next;
            odd.next = nextOdd;
            even.next = nextEven;
            odd = nextOdd;
            even = nextEven;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.oddEvenList(DataGenerator.buildListNode("1-2-3-4-5")));
        System.out.println(s.oddEvenList(DataGenerator.buildListNode("1-2-3-4")));
        System.out.println(s.oddEvenList(DataGenerator.buildListNode("1-2-3")));
        System.out.println(s.oddEvenList(DataGenerator.buildListNode("1-2")));
        System.out.println(s.oddEvenList(DataGenerator.buildListNode("1")));
    }
}
