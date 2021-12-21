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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null) {
            return false;
        }
        return isSameTreeHelper(p,q);
    }
    
    private boolean isSameTreeHelper(TreeNode p, TreeNode q) {
        boolean flag = true;
        if(p.val != q.val) {
            return false;
        }
        if(p.left != null && q.left != null) {
            flag = isSameTreeHelper(p.left, q.left);
        } else if(p.left != null || q.left != null) {
            return false;
        }
        if(p.right != null && q.right != null) {
            flag = flag && isSameTreeHelper(p.right, q.right);
        } else if(p.right != null || q.right != null) {
            return false;
        }
        return flag;
    }
}