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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            result.add(temp);
        }
        levelOrderHelper(root, result, 1);
        return result;
    }
    
    private void levelOrderHelper(TreeNode root, ArrayList<List<Integer>> result, int level) {
        if(root != null) {
            if(root.left!=null) {
                checkIfLevelExist(result, level).add(root.left.val);
            }
            if(root.right!=null) {
                checkIfLevelExist(result, level).add(root.right.val);
            }
            
            levelOrderHelper(root.left, result, level + 1);
            levelOrderHelper(root.right, result, level + 1);
        }
    }
    
    private List<Integer> checkIfLevelExist(ArrayList<List<Integer>> result, int level){
        if(result.size() <= level) {
            List<Integer> temp = new ArrayList<Integer>();
            result.add(temp);
            return temp;
        } else {
            return result.get(level);
        }
    }
}