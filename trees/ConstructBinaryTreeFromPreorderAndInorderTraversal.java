/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pLow, int pHigh, int[] inorder, int iLow, int iHigh) {
        if (iLow > iHigh) return null;

        int key = preorder[pLow];
        TreeNode node = new TreeNode(key);

        int iKey = getIndex(inorder, iLow, iHigh, key);
        node.left = build(preorder, pLow + 1, pLow + iKey - iLow, inorder, iLow, iKey - 1);
        node.right = build(preorder, pHigh + iKey - iHigh + 1, pHigh, inorder, iKey + 1, iHigh);

        return node;
    }

    private int getIndex(int[] inorder, int iLow, int iHigh, int key) {
        for (int i = iLow; i <= iHigh; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }
}