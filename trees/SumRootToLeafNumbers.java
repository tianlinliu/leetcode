sumNumbers(TreeNode root)
    return sum(root, path, result)

sum(root, int path, int result)
    if (root == null) return

    if (root.left == null && root.right == null)
        path = path * 10 + root.val;
        result += path

    sum(root.left, path, result)

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int path = 0;
        return sum(root, path);
    }

    private int sum(TreeNode root, int path) {
        if (root == null) return 0;

        int result = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return result;
        }

        return sum(root.left, result) + sum(root.right, result);
    }
}