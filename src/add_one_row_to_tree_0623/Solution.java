// https://leetcode.com/problems/add-one-row-to-tree

package add_one_row_to_tree_0623;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int targetDepth) {
        if (targetDepth == 1) {
            TreeNode newRootNode = new TreeNode(val);
            newRootNode.left = root;
            return newRootNode;
        }

        addOneRowRec(root, val, targetDepth, 1);
        return root;
    }

    public void addOneRowRec(TreeNode node, int val, int targetDepth, int currentDepth) {
        if (currentDepth + 1 == targetDepth) {
            TreeNode newLeftNode = new TreeNode(val);
            TreeNode newRightNode = new TreeNode(val);

            if (node.left != null) {
                newLeftNode.left = node.left;
            }

            if (node.right != null) {
                newRightNode.right = node.right;
            }

            node.left = newLeftNode;
            node.right = newRightNode;
        } else {
            if (node.left != null) {
                addOneRowRec(node.left, val, targetDepth, currentDepth + 1);
            }

            if (node.right != null) {
                addOneRowRec(node.right, val, targetDepth, currentDepth + 1);
            }
        }
    }
}