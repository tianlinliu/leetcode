/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) return 1;

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}