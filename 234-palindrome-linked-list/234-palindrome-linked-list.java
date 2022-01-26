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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null || head.next.next == null && head.val == head.next.val) {
            return true;
        } else if(head.next.next == null) {
            return false;
        }
        
        ListNode slow = head, fast = head, prev = null, temp;
        boolean even = true;
        
        while(fast != null) {
            fast = fast.next.next;
            
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
            if(fast == null) {
                continue;
            } else if(fast.next == null) {
                fast = null;
                even = false;
            } else if(fast.next.next == null) {
                fast = null;
                even = true;
            }
        }
        
        if(even) {
            if(slow.val != slow.next.val) {
                return false;
            }
            fast = slow.next.next;
        } else {
            fast = slow.next;
        }
        slow = prev;
        
        while(fast != null) {
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
}

/*
fast.next = null -> odd
fast.next.next = null -> even

[1,2,2,1]
[1]
[1,2]
[1,1]
[1,2,1]
[1,2,3]
[1,2,3,2]
[1,2,3,4,5,4,3,2,1]
[1,2,3,4,4,3,2,1]
*/