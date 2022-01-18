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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        
        root1.val += root2.val;
        
        // doing this so I can have the parent root.
        mergeTreesHelper(root1, true, root1.left, root2.left);
        mergeTreesHelper(root1, false, root1.right, root2.right);
        
        return root1;
    }
    
    private void mergeTreesHelper(TreeNode rootParent, boolean left, TreeNode root1, TreeNode root2) {
        // add
        if(root1 != null && root2 != null) {
            root1.val += root2.val;
            mergeTreesHelper(root1, true, root1.left, root2.left);
            mergeTreesHelper(root1, false, root1.right, root2.right);
        // parent of root1 now point to root2
        } else if(root2 != null) {
            if(left) {
                rootParent.left = root2;
            } else {
                rootParent.right = root2;
            }
        }
    }
}