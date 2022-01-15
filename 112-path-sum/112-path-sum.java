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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base case, if root = null, always false.
        if(root==null) return false;
        return hasPathSumHelper(root,targetSum, 0);
    }
    
    /*
     * Keep adding to sum, bc values can be neg
     */
    private boolean hasPathSumHelper(TreeNode root, int targetSum, int sum) {
        if(root == null) {
            return false;
        } else if(root.left == null && root.right == null) {
            return sum + root.val == targetSum;
        }
        sum += root.val;
        return hasPathSumHelper(root.left, targetSum, sum) || hasPathSumHelper(root.right, targetSum, sum);
    }
}

// [1,2]
// 1
// [-2,null,-3]
// -5