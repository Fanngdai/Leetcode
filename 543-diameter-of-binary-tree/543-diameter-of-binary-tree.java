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
    int max;
    
    public int diameterOfBinaryTree(TreeNode root) {
        depthOfTree(root);
        return max;
    }
    
    private int depthOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = depthOfTree(root.left);
        int right = depthOfTree(root.right);
        
        if(left + right > max) {
            max = left + right;
        }
        
        return Math.max(left, right) + 1;
    }
}

/*
[5,3,6,2,4,null,null,1]
[1,2,null,3,4,5,6,7,8]
*/