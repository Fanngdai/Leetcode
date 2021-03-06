/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return null;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=size-1; i>=0; i--) {
                Node tempNode = queue.poll();
                if(i!=0) {
                    tempNode.next = queue.peek();
                }
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        
        return root;
    }
}