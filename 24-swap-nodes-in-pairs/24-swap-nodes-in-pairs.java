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
    public ListNode swapPairs(ListNode head) {
        // base case, no need to swap
        if(head == null || head.next == null) {
            return head;
        }
        
        // curr is the pointer so we don't mess up
        // rtn is the return value, which should be the second node
        // temp is used in the loop to keep track of the third node
        ListNode curr = head, rtn = head.next, temp;
        
        while(curr != null && curr.next != null) {
            // keep track of the third node
            temp = curr.next.next;
            // the 2nd nodes next is the current 2 -> 1
            curr.next.next = curr;
            // curr.next should be 4, but what if it's only 2 values?
            // if odd nodes, first node should point to 3rd
            curr.next = temp == null ? null : temp.next == null ? temp : temp.next;
            // set the pointer to the third node
            curr = temp;
        }
        
        return rtn;
        
    }
}

/*
odd values, the last one stays the same
[1,2,3,4,5,6,7,8,9]
[1,2]
[1,2,3]
[1,2,3,4]
*/