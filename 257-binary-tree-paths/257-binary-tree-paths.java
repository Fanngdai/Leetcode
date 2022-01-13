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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rtn = new ArrayList<>();
        binaryTreePathsHelper(rtn, root, "");
        return rtn;
    }
    
    private void binaryTreePathsHelper(List<String> rtn, TreeNode root, String s) {        
        if(root == null) {
            return;
        } else if(root.left == null && root.right == null) {
            rtn.add(s + root.val);
            return;
        }
        s += root.val + "->";
        binaryTreePathsHelper(rtn, root.left, s);
        binaryTreePathsHelper(rtn, root.right, s);
    }
}