/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iLow, int iHigh, int[] postorder, int pLow, int pHigh) {
        if (iLow > iHigh) return null;

        int key = postorder[pHigh];
        TreeNode node = new TreeNode(key);

        int iKey = getIndex(inorder, iLow, iHigh, key);
        node.left = build(inorder, iLow, iKey - 1, postorder, pLow, pLow + iKey - iLow - 1);
        node.right = build(inorder, iKey + 1, iHigh, postorder, pHigh + iKey - iHigh, pHigh - 1);

        return node;
    }

    private int getIndex(int[] inorder, int iLow, int iHigh, int key) {
        for (int i = iLow; i <= iHigh; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
}