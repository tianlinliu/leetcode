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
public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < m - 1; i++) {
            cur = cur.next;
        }
        ListNode prevEnd = cur;

        cur = cur.next;
        ListNode prev = null;
        ListNode end = cur;
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        prevEnd.next = prev;
        end.next = cur;

        return dummy.next;
    }

    public static ListNode reverseBetween_insert(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        for (int i = 0; i < m - 1; i++) {
            current = current.next;
        }
        ListNode start = current;

        current = current.next;
        for (int i = m; i < n; i++) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = start.next;
            start.next = next;
        }
        return dummy.next;
    }

}