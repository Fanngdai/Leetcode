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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }
    
    private int maxPathSumHelper(TreeNode root) {
        int rtn, left, right;
        if(root.left == null && root.right == null) {
            rtn = root.val;
            max = Math.max(rtn, max);
        } else if(root.left == null) {
            right = maxPathSumHelper(root.right);
            rtn = findMaxVal(root.val, right+root.val);
            max = findMaxVal(max, right, rtn);
        } else if(root.right == null) {
            left = maxPathSumHelper(root.left);
            rtn = findMaxVal(root.val, left+root.val);
            max = findMaxVal(max, left, rtn);
        } else {
            left = maxPathSumHelper(root.left);
            right = maxPathSumHelper(root.right);
            rtn = findMaxVal(root.val, left+root.val, right+root.val);
            max = findMaxVal(max, left, right, rtn, right+left+root.val);
        }
        return rtn;
    }
    
    private int findMaxVal(int... val) {
        int rtn = Integer.MIN_VALUE;
        for(int v: val) {
            rtn = Math.max(rtn, v);
        }
        return rtn;
    }
}

/*
[-3]
[1,-2,-3,1,3,-2,null,-1]
[-1,-2,-3]
[5,4,8,11,null,13,4,7,2,null,null,null,1]
 */