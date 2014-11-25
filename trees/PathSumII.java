/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    /*
    pathSum(root, sum)
        List<List<Integer>> result = new List<>();
        List<Integer> path = new List<>()

    void helper(root, sum, path, result)
        if root == null return;

        path.add(root)
        if root.left == null && root.right == null
            if root.val == sum
                result.add(path)
            return

        helper(root.left, sum - root.val, path, result)
        helper(root.right)
    */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(root, sum, path, result);
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                path.add(root.val);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        path.add(root.val);
        helper(root.left, sum - root.val, path, result);
        helper(root.right, sum - root.val, path, result);
        path.remove(path.size() - 1);
    }
}