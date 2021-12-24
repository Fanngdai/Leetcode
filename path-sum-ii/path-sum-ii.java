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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rtn = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSumHelper(root, targetSum, temp, rtn);
        return rtn;
    }
    
    private void pathSumHelper(TreeNode root, int targetSum, List<Integer> input, List<List<Integer>> rtn) {    
        if(root != null && root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                input.add(root.val);
                rtn.add(input);
            }
        } else if(root != null) {
            input.add(root.val);
            pathSumHelper(root.left, targetSum - root.val, new ArrayList<Integer>(input), rtn);
            pathSumHelper(root.right, targetSum - root.val, new ArrayList<Integer>(input), rtn);
        }
    }
}