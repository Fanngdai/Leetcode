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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root!=null) {
            result.add(root.val);
            rightSideViewHelper(root, result, 1);
        }
        return result;
    }
    
    private void rightSideViewHelper(TreeNode root, List<Integer> result, int level) {
        if(root == null) {
            return;
        }
        
        // Replace value at that level if exist, otherwise add new index
        if(result.size() < level) {
            result.add(root.val);
        } else {
            result.set(level-1, root.val);
        }
        
        if(root.left != null) {
            rightSideViewHelper(root.left, result, level + 1);
        }
        if(root.right != null) {
            rightSideViewHelper(root.right, result, level + 1);
        }
    }

}