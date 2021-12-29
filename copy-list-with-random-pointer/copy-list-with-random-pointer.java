/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Node curr = head;
        while(curr != null) {
            // make new node
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            newNode.random = curr.random;
            // insert after head
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        curr = head;
        Node rtn = curr.next;
        while(curr != null) {
            // set the randoms
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null) {
            // revert back to orignal
            Node copy = curr.next;
            curr.next = curr.next.next;
            copy.next = copy.next == null ? null : copy.next.next;
            curr = curr.next;
        }
        
        return rtn;
    }
}