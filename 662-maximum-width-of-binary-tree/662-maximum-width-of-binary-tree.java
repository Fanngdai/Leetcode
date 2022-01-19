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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);
        int max = 0, leftmost = 0, rightmost = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode tempNode = queue.poll();
                
                if(i==0) {
                    leftmost = tempNode.val;
                }
                
                if(i==size-1) {
                    rightmost = tempNode.val;
                }
                
                if(tempNode.left != null) {
                    tempNode.left.val = tempNode.val*2;
                    queue.add(tempNode.left);
                }
                
                if(tempNode.right != null) {
                    tempNode.right.val = tempNode.val*2+1;
                    queue.add(tempNode.right);
                }
            }
            max = Math.max(max, rightmost - leftmost + 1);
        }
        return max;
    }
}

/*
2*i+1
2*i+2

[1,3,2,5,null,null,9,6,null,null,7]
[1,2]
*/