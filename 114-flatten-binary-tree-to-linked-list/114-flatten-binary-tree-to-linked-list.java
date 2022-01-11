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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        if(root.left != null) {
            // flatten the left
            flatten(root.left);

            // make the left side, the right side
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;

            // go down, until the right is empty, to put in the original right
            TreeNode curr = root.right;
            while(curr.right != null) {
                curr = curr.right;
            }

            curr.right = right;
        }
        
        flatten(root.right);
    }
}