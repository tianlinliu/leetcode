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
public class RotateRight {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;

        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head;

        int k = len - n % len;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        ListNode result = cur.next;
        cur.next = null;

        return result;
    }
}