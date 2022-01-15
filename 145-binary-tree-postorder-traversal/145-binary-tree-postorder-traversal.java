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
        return postorderTraversalStack(root);
        // return postorderTraversalRecursion(root);
    }
    
    /*
     * The idea is to get all the way to the leaf
     * then traverse back up
     * You want all the subtrees to be added prior to the root
     */
    private List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> rtn = new ArrayList<>();
        if(root == null) return rtn;
        Stack<TreeNode> stack = new Stack<>();
        addUntilLeaf(root, stack);
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(root != temp.right) {
                addUntilLeaf(temp.right, stack);
            }
            root = stack.pop();
            rtn.add(root.val);
        }
        
        return rtn;
    }
    
    private void addUntilLeaf(TreeNode root, Stack<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left == null ? root.right : root.left;
        }
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

/*
[2,null,3,null,1] -> [1,3,2]
[1,4,3,null,null,null,2]
[1,null,4,3,null,null,2]
[2,null,3,null,1, 4,null, 5, 6,7,8,9,10,1,1] -> bigger tree for the funs
*/