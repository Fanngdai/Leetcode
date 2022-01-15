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
        return preorderTraversalStack(root);
        // return preorderTraversalRecursion(root);
    }
    
    private List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        if(root == null) return rtn;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
            rtn.add(root.val);
        }
        
        return rtn;
    }
    
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