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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return buildTreeHelper(pre, in);
    }
    
    private TreeNode buildTreeHelper(List<Integer> preorder, List<Integer> inorder) {
        int val = preorder.get(0);
        TreeNode root = new TreeNode(val);
        int inorderValIndex = inorder.indexOf(val);
        
        List<Integer> left = inorder.subList(0, inorderValIndex);
        List<Integer> right = inorder.subList(inorderValIndex+1, inorder.size());
        preorder.remove(0);
        
        if(left.size() > 0)
            root.left = buildTreeHelper(preorder, left);
        if(right.size() > 0)
            root.right = buildTreeHelper(preorder, right);
        
        return root;
    }
}

/*
 * To prune, have an index for preorder and inorder and pass it in a as a param, but I
 * got other problems to solve sooooo peaceeeeee
 */