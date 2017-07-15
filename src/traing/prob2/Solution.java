package traing.prob2;

import traing.ListNode;

public class Solution {
    private int i = 0;
    ListNode zero = new ListNode(0);
    // TODO: This solution is way too ugly...
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int digitResult = l1.val + l2.val + i;
        int d = digitResult % 10;
        i = (int) digitResult / 10;

        if (l1.next != null && l2.next != null) {
            ListNode result = new ListNode(d);

            result.next = this.addTwoNumbers(l1.next, l2.next);

            return result;
        } else if (l1.next != null || l2.next != null) {
            ListNode result = new ListNode(d);
            ListNode one = l1.next == null ? zero : l1.next;
            ListNode two = l2.next == null ? zero : l2.next;

            result.next = this.addTwoNumbers(one, two);

            return result;
        } else {
            ListNode l = new ListNode(d);
            if (i > 0) {
                l.next = new ListNode(i);
            }
            return l;
        }

    }

    public static void main(String[] args) {
        System.out.println((int) 12 / 10);
    }
}
