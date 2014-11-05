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
public class SortList {
    /*
    sortList(head)
        dummy.next = head;
        slow = dummy;
        fast = dummy;
        while (fast != null && fast.next != null)
            fast = fast.next.next;
            slow = slow.next;
        return merge(sortList(head), sortList(slow))

    merge(l1, l2)
        cur = dummy
        while (l1 != null && l2 != null)
            if (l1.val <= l2.val)
                cur.next = l1
                l1 = l1.next
            else
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 == null ? l2 : l1
        return dummy.next;
    */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextHead = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(nextHead));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}