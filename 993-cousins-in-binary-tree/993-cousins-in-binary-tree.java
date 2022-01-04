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
    HashMap<Integer, Integer> nodeLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        nodeLevel = new HashMap<>();
        TreeNode parentNode = isCousinsHelper(root, x, y, 1);
        
        if(nodeLevel.get(x) != nodeLevel.get(y) || 
           (parentNode.left.val == x && parentNode.right.val == y ||
          parentNode.right.val == x && parentNode.left.val == y))
            return false;
        
        return true;
    }
    
    private TreeNode isCousinsHelper(TreeNode root, int x, int y, int depth) {
        if(root == null) {
            return null;
        }
        
        if(root.val == x) {
            nodeLevel.put(x, depth);
            return root;
        }
        if(root.val == y) {
            nodeLevel.put(y, depth);
            return root;
        }
        
        TreeNode left = isCousinsHelper(root.left, x, y, depth + 1);
        TreeNode right = isCousinsHelper(root.right, x, y, depth + 1);
        
        if(left != null && right != null) {
            return root;
        }
        
        return left == null ? right : left;
    }
}