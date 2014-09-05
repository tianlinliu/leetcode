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
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        int len = length(head);
        int groupNum = len / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevEnd = dummy;
        ListNode cur = head;
        for (int i = 0; i < groupNum; i++) {
            ListNode prev = null;
            ListNode end = cur;
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            prevEnd.next = prev;
            prevEnd = end;
        }
        prevEnd.next = cur;

        return dummy.next;
    }

    private static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }



    public ListNode reverseKGroup_1(ListNode head, int k) {
        if (head == null || k <= 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode nextGroup = head;
        ListNode current = head;
        while (nextGroup != null) {
            // check length
            for (int i = 0; i < k; i++) {
                if (nextGroup == null) {
                    return dummy.next;
                }
                nextGroup = nextGroup.next;
            }

            // reverse a group
            for (int i = 0; i < k - 1; i++) {
                ListNode next = current.next;
                current.next = next.next;
                next.next = start.next;
                start.next = next;
            }

            // set next start point
            start = current;
            current = current.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup_2(ListNode head, int k) {
        if (head == null || k <= 0) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int n = length(head) / k;

        ListNode start = dummy;
        for (int i = 0; i < n; i++) {
            ListNode current = start.next;
            for (int j = 0; j < k - 1; j++) {
                ListNode next = current.next;
                current.next = next.next;
                next.next = start.next;
                start.next = next;
            }
            start = current;
        }
        return dummy.next;
    }



}