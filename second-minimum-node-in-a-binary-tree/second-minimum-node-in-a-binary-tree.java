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
    public int findSecondMinimumValue(TreeNode root) {
        int rtn = findSecondMinimumValueHelper(root, root.val);
        return rtn == root.val ? -1 : rtn;
        
    }
    
    private int findSecondMinimumValueHelper(TreeNode root, int min) {
        if(root == null)
            return -1;
        if(root.val > min)
            return root.val;
        
        int left = findSecondMinimumValueHelper(root.left, min);
        int right = findSecondMinimumValueHelper(root.right, min);
        
        if(left == -1) {
            return right;
        } else if(right == -1) {
            return left;
        } else {
            return Math.min(left,right);
        }
    }
}

// [2,2,5,null,null,5,7]
// [2,2,2]
// [5,8,5]