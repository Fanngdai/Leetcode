/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode pointer1 = head, pointer2 = head;
        
        while(true) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next == null ? null : pointer2.next.next;
            if(pointer2 == null)
                return false;
            if(pointer1 == pointer2)
                return true;
        }
    }
}

