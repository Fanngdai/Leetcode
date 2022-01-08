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
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode rev = reverseNode(mid);
        
        // interleave
        ListNode tempHead, tempRev;
        while(rev != mid) {
            tempHead = head;
            tempRev = rev;
            
            head = head.next;
            rev = rev.next;
            
            tempHead.next = tempRev;
            tempRev.next = head;
        }
    }
    
    private ListNode midNode(ListNode head) {
        ListNode walker = head, runner = head.next;
        while(runner != null) {
            walker = walker.next;
            runner = runner.next == null ? null : runner.next.next;
        }
        return walker;
    }
    
    private ListNode reverseNode(ListNode head) {
        ListNode prev = null, curr = head, next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}