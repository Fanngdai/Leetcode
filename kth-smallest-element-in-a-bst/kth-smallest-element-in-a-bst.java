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
    int amt;
    public int kthSmallest(TreeNode root, int k) {
        this.amt = k;
        TreeNode node = inOrder(root);
        return node == null ? -1 : node.val;
    }
    
    private TreeNode inOrder(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode left = inOrder(root.left);
        if(left != null)
            return left;
        if(--this.amt == 0)
            return root;
        return inOrder(root.right);
    }
}