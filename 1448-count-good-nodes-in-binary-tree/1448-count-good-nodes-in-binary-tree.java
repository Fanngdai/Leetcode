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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return goodNodesHelper(root.left, root.val) + goodNodesHelper(root.right, root.val) + 1;
    }
    
    private int goodNodesHelper(TreeNode root, int maxVal) {
        if(root == null) return 0;
        
        if(root.val < maxVal) {
            return goodNodesHelper(root.left, maxVal) + goodNodesHelper(root.right, maxVal);
        } else {
            return goodNodesHelper(root.left, root.val) + goodNodesHelper(root.right, root.val) + 1;
        }
    }
}