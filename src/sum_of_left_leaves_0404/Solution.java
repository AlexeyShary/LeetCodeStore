package sum_of_left_leaves_0404;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;

        if (root == null) {
            return result;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            } else {
                result += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            result += sumOfLeftLeaves(root.right);
        }

        return result;
    }
}