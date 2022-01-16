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
    public TreeNode pruneTree(TreeNode root) {
        if(!pruneTreeHelper(root)) {
            return null;
        }
        return root;
    }
    
    private boolean pruneTreeHelper(TreeNode root) {
        if(root == null) {
            return false;
        }
        
        boolean left = pruneTreeHelper(root.left);
        boolean right = pruneTreeHelper(root.right);
        
        if(!left) {
            root.left = null;
        }
        if(!right) {
            root.right = null;
        } 
        
        return left || right || root.val == 1;
    }
}

/*
[1,null,0,0,1]
[1,0,1,0,0,0,1]
[1,1,0,1,1,0,1,0]
[1]
[0]
[1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0]
[1,1,0,0,1,1,0,0,1,1,0,0]
[0,null,0,0,0]
[1,0,0,0,0,0,0]
*/