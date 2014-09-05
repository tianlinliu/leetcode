/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        // find mid
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow.next;
        ListNode l1 = head;
        slow.next = null;

        // reverse
        ListNode l2Prev = null;
        while (l2 != null) {
            ListNode next = l2.next;
            l2.next = l2Prev;
            l2Prev = l2;
            l2 = next;
        }
        l2 = l2Prev;

        // merge
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail.next.next = l2;
            l2 = l2.next;
            tail = tail.next.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
    }
}