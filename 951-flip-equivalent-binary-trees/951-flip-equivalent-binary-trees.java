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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipEquivHelper(root1, root2);
    }
    
    private boolean flipEquivHelper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        
        if(root1.left == null && root2.left == null ||
           root1.left != null && root2.left != null && root1.left.val == root2.left.val) {
            return flipEquivHelper(root1.left, root2.left) && flipEquivHelper(root1.right, root2.right);
        } else {
            return flipEquivHelper(root1.left, root2.right) && flipEquivHelper(root1.right, root2.left);
        }
    }
}

/*
[0,null,1]
[0,null,1]
*/