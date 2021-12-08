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
    public int countNodesFirstAttempt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int treeHeight = getHeight(root);
        return binSearch(root, treeHeight) + (int)Math.pow(2, treeHeight-1);
    }
    
    /*
     * one right then all left, should be the middle of the node
     */
    private int binSearch(TreeNode root, int height) {        
        if(height==1) {
            return 0;
        } else {
            int counter = height-1;
            TreeNode temp = root.right;
            while(counter-- != 1) {
                temp = temp.left;
            }
            
            if(temp == null) {
                return binSearch(root.left, height-1);
            } else {
                return binSearch(root.right, height-1) + ((int)Math.pow(2,height-1))/2;
            }
        }
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return getHeight(root.left) + 1;
        }
    }
    
    
}