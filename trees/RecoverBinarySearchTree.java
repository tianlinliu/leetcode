/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) return;

        ArrayList<TreeNode> treeList = new ArrayList<>();
        ArrayList<Integer> valList = new ArrayList<>();
        getInorder(root, treeList, valList);
        if (treeList.size() <= 1) return;

        Collections.sort(valList);

        for (int i = 0; i < treeList.size(); i++) {
            if (treeList.get(i).val != valList.get(i)) {
                treeList.get(i).val = valList.get(i);
            }
        }
    }

    private void getInorder(TreeNode root, ArrayList<TreeNode> treeList, ArrayList<Integer> valList) {
        if (root == null) return;

        getInorder(root.left, treeList, valList);
        treeList.add(root);
        valList.add(root.val);
        getInorder(root.right, treeList, valList);
    }
}