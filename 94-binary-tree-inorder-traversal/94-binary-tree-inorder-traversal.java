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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalStack(root);
        // return inorderTraversalRecursion(root);
    }
    
    private List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        addLeft(stack, root);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            rtn.add(root.val);
            addLeft(stack, root.right);
        }
        
        return rtn;
    }
    
    private void addLeft(Stack<TreeNode> stack, TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    private List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        inorderTraversalHelper(root, rtn);
        return rtn;
    }
    
    private void inorderTraversalHelper(TreeNode root, List<Integer> lst) {
        if(root == null) return;
        inorderTraversalHelper(root.left, lst);
        lst.add(root.val);
        inorderTraversalHelper(root.right, lst);
    }
}