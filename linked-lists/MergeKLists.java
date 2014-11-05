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
public class MergeKLists {
    /*
    mergeKLists(lists)
        int size = lists.size
        if size == 0 || 1 return lists

        mid = size / 2
        List l = mergeKLists(lists.sublist(0, mid))
        List r = mergeKLists(lists.sublist(mid + 1, size - 1));

        return merge(l, r)
    */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        int K = lists.size();
        if (K == 1) return lists.get(0);

        int mid = K / 2;
        ListNode l = mergeKLists(lists.subList(0, mid));
        ListNode r = mergeKLists(lists.subList(mid, K));

        return merge(l, r);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}