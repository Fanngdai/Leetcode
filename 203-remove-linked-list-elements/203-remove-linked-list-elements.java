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
    public ListNode removeElements(ListNode head, int val) {
        ListNode rtn = head;
        
        // remove the heads if values are the same, stop when the head is not the val
        while(rtn != null && rtn.val == val) {
            rtn = rtn.next;
        }
        
        // if there are no more nodes left
        if(rtn == null) {
            return null;
        }
        
        // remove all node vals after.
        ListNode prev = rtn;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        
        return rtn;
    }
}