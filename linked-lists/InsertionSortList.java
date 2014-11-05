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
public class InsertionSortList {
    /*
    insertionSortList(head)
        ListNode dummy.next = head
        cur = head
        while (cur.next != null)
            ListNode prev = dummy
            while (prev.next != cur.next ) {
                if (prev.next.val >= cur.next.val) {
                    // delete
                    ListNode node = cur.next;
                    cur.next = cur.next.next;
                    // insert
                    ListNode next = prev.next;
                    prev.next = node;
                    node.next = next;
                }
            }
            cur = cur.next;
        return dummy.next
    */

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            ListNode prev = dummy;
            while (prev.next != cur.next && prev.next.val < cur.next.val) {
                prev = prev.next;
            }

            if (prev.next != cur.next) {
                ListNode node = cur.next;
                cur.next = cur.next.next;

                ListNode next = prev.next;
                prev.next = node;
                node.next = next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


}