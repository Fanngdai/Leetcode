/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        int counter = getSize(head) - n;
        
        // if we need to remove the head, just return head's next.
        if(counter==0)
            return head.next;
        
        // loop until we get the node prior to the node we want to remove
        for(int i=0; i<counter-1; i++) {
            prev = prev.next;
        }
        
        // remove that node
        prev.next = prev.next.next;
        
        return head;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while(head!=null) {
            size++;
            head = head.next;
        }
        return size;
    }
}