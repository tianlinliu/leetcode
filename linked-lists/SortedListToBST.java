/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedListToBST {
    /*
    binary search

    sortedListToBST(head)
        ListNode mid = findMid(head)
        TreeNode root = new TreeNode(mid.val)
        rightHead = mid.next
        mid.next = null
        root.left = sortedListToBST(head)
        root.right = sortedListToBST(rightHead)
        return root
    */

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode preMid = findPreMid(head);
        TreeNode root = new TreeNode(preMid.next.val);
        ListNode rightHead = preMid.next.next;
        preMid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);
        return root;
    }

    private ListNode findPreMid(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}