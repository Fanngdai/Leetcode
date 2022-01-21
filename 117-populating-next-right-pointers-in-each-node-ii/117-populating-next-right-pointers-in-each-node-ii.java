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
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node curr = queue.poll();
            for(int i=0; i<size; i++) {
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(i != size-1) {
                    Node temp = queue.poll();
                    curr.next = temp;
                    curr = temp;
                }
            }
            curr.next = null;
        }
            
        return root;
    }
}

/*
Logic
    Have a queue so we are doing it BFS
        Go through each level and point to the next
        But if the next is the last value, then it should point to null
        Thus, we have the case i != size -1 which is the last node in the level
*/