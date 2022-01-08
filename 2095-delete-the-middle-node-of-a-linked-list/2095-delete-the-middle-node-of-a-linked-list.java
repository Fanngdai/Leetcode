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
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = null, walker = head, runner = head.next;
        while(runner != null) {
            prev = walker;
            walker = walker.next;
            runner = runner.next == null ? null : runner.next.next;
        }
        
        if(prev == null)
            return null;
        
        prev.next = prev.next.next;
        
        return head;
    }
}