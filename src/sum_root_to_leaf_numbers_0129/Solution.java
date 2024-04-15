// https://leetcode.com/problems/sum-root-to-leaf-numbers

package sum_root_to_leaf_numbers_0129;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int val) {
        val *= 10;
        val += root.val;

        if (root.left == null && root.right == null) {
            return val;
        }

        int result = 0;

        if (root.left != null) {
            result += sumNumbers(root.left, val);
        }

        if (root.right != null) {
            result += sumNumbers(root.right, val);
        }

        return result;
    }
}
