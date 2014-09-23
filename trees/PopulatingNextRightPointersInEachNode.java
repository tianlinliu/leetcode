/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                TreeLinkNode prev = queue.poll();
                if (prev.left != null) {
                    queue.offer(prev.left);
                }
                if (prev.right != null) {
                    queue.offer(prev.right);
                }

                TreeLinkNode node = queue.peek();
                prev.next = node;
                prev = node;
            }
            TreeLinkNode last = queue.poll();
            if (last.left != null) {
                queue.offer(last.left);
            }
            if (last.right != null) {
                queue.offer(last.right);
            }
        }
    }
}