/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private boolean isValidBSTHelper(TreeNode root, double less, double greater) {
        if(root == null) {
            return true;
        }
        if(less < root.val && root.val < greater) {
            return isValidBSTHelper(root.left, less, root.val) && isValidBSTHelper(root.right, root.val, greater);
        }
        return false;
    }
}