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
    /*
     * BFS
     */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int depth = 1;
        
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp.left == null && temp.right == null) {
                break;
            }
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
            // everytime we reach null, it means we have reached the next depth
            if(queue.peek() == null) {
                queue.poll();
                depth++;
                queue.add(null);
            }
        }
        
        return depth;
    }
}