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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rtn = new ArrayList<>();
        if(root == null) return rtn;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lvl = 1;
        
        while(!queue.isEmpty()) {
            List<Integer> tempLst = new ArrayList<>();
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
                
                // add to list by start or the end
                tempLst.add(lvl%2==1 ? tempLst.size() : 0,node.val);
            }
            
            lvl++;
            rtn.add(tempLst);
        }
        
        return rtn;
    }
}

/*
 what about null values btw nodes like from example if 9 has a left
 nulls are ignored
 
 Well you can use stack and queues, but that's 2 data structures.
 Why not use an arraylist
    if odd -> 0,list.size
    if even -> list.size,0
*/