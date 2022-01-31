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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        k = k%countNodes(head);
        ListNode kVal = head, rtn = head;
        
        for(int i=0; i<k; i++) {
            kVal = kVal.next;
        }
        
        while(kVal.next != head) {
            rtn = rtn.next;
            kVal = kVal.next;
        }
        
        kVal = rtn;
        rtn = rtn.next;
        kVal.next = null;
        
        return rtn;
    }
    
    private int countNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;
        
        do {
            if(temp.next == null) {
                temp.next = head;
            }
            temp = temp.next;
            count++;
        } while(temp!=head);
        
        return count;
    }
}

/*
[1]
1
[1,2]
2
[1,2,3,4]
2
[1,2,3,4,5]
2
[0,1,2]
4
[]
0
*/