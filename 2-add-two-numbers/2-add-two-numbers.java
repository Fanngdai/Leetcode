/*
 * replace values in l2
 * add all the values, l1, l2 and carryover
 *      mod of sum will be put in l2. since the largest we can have is 2 digits.
 *      carryover will be the sum divided by 10.
 
 * we are returning l2, so if l2 runs out before l1, then l2 will take over the remaining l1.
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rtn = l2;
        int carryover = 0, sum;
        
        while(l1 != null || l2 != null) {
            sum = carryover;
            
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            sum += l2.val;
            l2.val = sum % 10;
            carryover = sum / 10;
            
            if(l2.next == null && l1 != null) {
                l2.next = l1;
                l1 = null;
            } else if(l2.next == null && carryover != 0) {
                ListNode temp = new ListNode(carryover);
                l2.next = temp;
                carryover = 0;
            }
            
            l2 = l2.next;
        }
        return rtn;
    }
    
}

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