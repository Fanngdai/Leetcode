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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> rtn = new ArrayList<>();
        
        // Put all toDelete into set for easier access to check
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        
        delNodesHelper(null, root, rtn, set, false, false);
        
        return rtn;
    }
    
    private void delNodesHelper(TreeNode parentRoot, TreeNode root, List<TreeNode> rtn,
                                Set<Integer> toDelete, boolean inLst, boolean left) {
        if(toDelete.isEmpty() || root == null) {
            return;
        }
        
        if(toDelete.contains(root.val)) {
            delNodesHelper(root, root.left, rtn, toDelete, false, true);
            delNodesHelper(root, root.right, rtn, toDelete, false, false);
            toDelete.remove(root.val);
            
            if(parentRoot != null) {
                if(left) {
                    parentRoot.left = null;
                } else {
                    parentRoot.right = null;
                }
            }
        } else {
            if(!inLst) {
                rtn.add(root);
            }
            delNodesHelper(root, root.left, rtn, toDelete, true, true);
            delNodesHelper(root, root.right, rtn, toDelete, true, false);
        }
    }
}