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
    public boolean isSymmetric(TreeNode root) {
        return swapAndCheck(root.left, root.right);
    }
    
    private boolean swapAndCheck(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) {
            return true;
        } else if(leftNode == null || rightNode == null) {
            return false;
        } else if(leftNode.val == rightNode.val) {
            return swapAndCheck(leftNode.left, rightNode.right) && swapAndCheck(leftNode.right, rightNode.left);
        }
        
        return false;
    }
}