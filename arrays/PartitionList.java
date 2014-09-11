/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode largeHead = new ListNode(-1);
        ListNode largeTail = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }

        smallTail.next = largeHead.next;
        largeTail.next = null;
        return smallHead.next;
    }
}