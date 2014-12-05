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
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = 0;
        ListNode curA = headA;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        int lenB = 0;
        ListNode curB = headB;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        ListNode curLong = lenA >= lenB ? headA : headB;
        ListNode curShort = lenA < lenB ? headA : headB;
        int diff = Math.abs(lenA - lenB);
        while (diff > 0) {
            curLong = curLong.next;
            diff--;
        }

        while (curLong != null) {
            if (curLong == curShort) {
                return curLong;
            }
            curLong = curLong.next;
            curShort = curShort.next;
        }

        return null;
    }
}