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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversalRecursion(root);
    }
    
    // private List<Integer> preorderTraversalStack(TreeNode root) {
    //     List<Integer> rtn = new ArrayList<>();
    //     Stack<>()
    // }
    
    private List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        preorderTraversalRecursionHelper(root, rtn);
        return rtn;
    }
    
    private void preorderTraversalRecursionHelper(TreeNode root, List<Integer> lst) {
        if(root == null) return;
        lst.add(root.val);
        preorderTraversalRecursionHelper(root.left, lst);
        preorderTraversalRecursionHelper(root.right, lst);
    }
}