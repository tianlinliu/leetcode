/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tail = dummy;
        RandomListNode cur = head;
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        while (cur != null) {
            RandomListNode copy = null;
            if (!map.containsKey(cur.label)) {
                copy = new RandomListNode(cur.label);
            } else {
                copy = map.get(cur.label);
            }

            if (cur.random != null) {
                if (!map.containsKey(cur.random.label)) {
                    copy.random = new RandomListNode(cur.random.label);
                } else {
                    copy.random = map.get(cur.random.label);
                }
            }

            cur = cur.next;
            tail.next = copy;
            tail = tail.next;
        }

        return dummy.next;
    }
}