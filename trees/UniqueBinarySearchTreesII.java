/*
public class Solution {
    helper(n, start, end, result)
        if start < 1 || end > n || start > end
            return

        for i = start to end
            TreeNode node = new TreeNode(start)
            node.left = helper(n, start, i - 1, result)
            node.right = helper(n, i + 1, end, result)


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n < 1) return result;

        helper(n, 0, n, result);
        return result;
    }

    private void helper(int n, int start, int end, List<Integer> result) {
        if (start < 1 || end > n || start > end) {
            return;
        }

        for (int i = start; i < end; i++) {
            TreeNode node = new TreeNode(i);
            node.left = helper(n, start, i - 1, result);
            node.right = helper(n, i + 1, end, result);
        }
    }
}
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }

        return result;
    }
}