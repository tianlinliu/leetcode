/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        flatten(root.right);
        if (root.left != null) {
            flatten(root.left);

            TreeNode leftTail = root.left;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }

            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}