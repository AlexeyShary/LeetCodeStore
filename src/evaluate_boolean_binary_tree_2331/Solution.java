// https://leetcode.com/problems/evaluate-boolean-binary-tree
package evaluate_boolean_binary_tree_2331;

class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) & evaluateTree(root.right);
        }
    }
}