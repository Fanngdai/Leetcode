/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * head -> beforeStart -> tail
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == 1) {
            return reverse(head, right - left + 1);
        } else {
            ListNode beforeStart = head;
            for(int i=1; i<left-1; i++) {
                beforeStart = beforeStart.next;
            }
            beforeStart.next = reverse(beforeStart.next, right - left + 1);
        }
        return head;
    }
    
    private ListNode reverse(ListNode head, int move) {
        ListNode prev = null;
        ListNode startNode = head; 
            
        while(move != 0) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            move--;
        }
        
        startNode.next = head;
        return prev;
    }
}