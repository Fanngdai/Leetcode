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
class BSTIterator {
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeft(root);
    }
    
    // first you want to remove this node, but when you remove, you might have right nodes
    // what you want to do is take that value which is no longer going to be in the stack
    // and check if there are any right values, in the case it does, keep adding it
    // into the stack
    public int next() {
        // if(stack.isEmpty()) return -1;
        TreeNode temp = stack.pop();
        addLeft(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    // keeps adding the left node
    private void addLeft(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */