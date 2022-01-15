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
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversalRecursion(root);
    }
    
    private List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        postorderTraversalRecursionHelper(root, rtn);
        return rtn;
    }
    
    private void postorderTraversalRecursionHelper(TreeNode root, List<Integer> lst) {
        if(root == null) return;
        postorderTraversalRecursionHelper(root.left, lst);
        postorderTraversalRecursionHelper(root.right, lst);
        lst.add(root.val);
    }
}