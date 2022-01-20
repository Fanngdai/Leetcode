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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode rtn = head;
        
        while(head.next!=null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        
        return rtn;
    }
}

/*
Logic, if the next value is null, this current node will point to the next next value
    if they are different, head is now the next value which is different and it will compare to it's next node
    The problem is what happens if next is null?
        Then we want to just end it.
*/