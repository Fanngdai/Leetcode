/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        flattenRec(head);
        return head;
    }
    
    public Node flattenRec(Node head) {
        // Need head to return later
        Node counter = head;

        // loop through columns
        while(counter != null) {
            if(counter.child != null) {
                // the head of the child
                Node baby = flattenRec(counter.child);
                // A reference to head's next, which will be later be attached back to the baby's tail
                Node toAttachBack = counter.next;
                counter.next = baby;
                baby.prev = counter;
                counter.child = null;
                if(toAttachBack != null) {
                    while(baby.next!=null) {
                     baby = baby.next;   
                    }
                    baby.next = toAttachBack;
                    toAttachBack.prev = baby;
                    counter = toAttachBack;
                } else {
                    return head;
                }
            }
            counter = counter.next;
        }
        
        
        return head;
    }
}