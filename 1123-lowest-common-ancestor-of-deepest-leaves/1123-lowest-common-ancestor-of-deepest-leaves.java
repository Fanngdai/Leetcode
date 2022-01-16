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
    TreeNode lcaNode;
    int deepest;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        deepest = -1;
        lcaDeepestLeavesHelper(root, 0);
        return lcaNode;
    }
    
    private int lcaDeepestLeavesHelper(TreeNode root, int lvl) {
        if(root == null) {
            deepest = Math.max(deepest, lvl);
            return lvl;
        }
        
        int left = lcaDeepestLeavesHelper(root.left, lvl+1);
        int right = lcaDeepestLeavesHelper(root.right, lvl+1);
        
        if(left == right && left == deepest) {
            lcaNode = root;
        }
        
        return Math.max(left, right);
    }
    
    private boolean resultIsLeaf() {
        return lcaNode == null || lcaNode.left == null || lcaNode.right == null;
    }
}

/*
https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
Same problem.

The logic is find the node which contains all the deepest nodes

Test cases:
[3,5,1,6,2,0,8,null,null,7,4]
[1]
[0,1,3,null,2]
[3,null,2,null,4,null,5]
[3,2,null,4,null,5]
[3,null,2,4,null,null,5]
[1,2,3]
[0,1]
[0,null,1]
[1,2,null,3,4,null,6,null,5]
[1,2,null,3,4,null,null,5]
*/