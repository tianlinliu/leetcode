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
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode prev = cur;
                while (cur.next != null && prev.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}