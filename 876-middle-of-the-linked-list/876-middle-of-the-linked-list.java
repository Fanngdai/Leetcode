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
    public ListNode middleNode(ListNode head) {
        if(head.next == null) return head;
        ListNode turtle = head, hare = head;
        
        while(hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }
        
        return turtle;
    }
}

/*
Logic:
    should draw it out with the examples given.
    turtle moves one at a time
    hare moves double that
    so turtle will always end up at the middle
    
[1,2,3,4,5]
[1,2,3,4,5,6]

[1]     -> returns [1]
[1,2]   -> returns [2]
*/