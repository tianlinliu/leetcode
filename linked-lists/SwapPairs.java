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
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        // if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevEnd = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nextPair = cur.next.next;
            prevEnd.next = cur.next;
            prevEnd.next.next = cur;
            prevEnd = cur;
            cur = nextPair;
        }
        prevEnd.next = cur;

        return dummy.next;
    }

    public ListNode swapPairs_2(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        ListNode start = dummy;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = start.next;
            start.next = next;

            start = current;
            current = current.next;
        }
        return dummy.next;
    }
}