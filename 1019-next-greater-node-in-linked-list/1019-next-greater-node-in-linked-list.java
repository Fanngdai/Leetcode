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
    public int[] nextLargerNodes(ListNode head) {
        ListNode headKeeper = head;
        Stack<ListNode> stack = new Stack<>();
        int lstSize = 0;
        
         do {
            while(!stack.isEmpty() && head.val > stack.peek().val) {
                stack.pop().val = head.val;
            }
            lstSize++;
            stack.push(head);
            head = head.next;
        } while(head != null);
        
        // make all the rest vals 0
        while(!stack.isEmpty()) {
            stack.pop().val = 0;
        }
        
        int[] rtn = new int[lstSize];
        for(int i=0; i<lstSize; i++) {
            rtn[i] = headKeeper.val;
            headKeeper = headKeeper.next;
        }
        
        return rtn;
    }
}

// [4,3,2,1] -> [0,0,0,0]
// [4,3,2,2] -> [0,0,0,0]
// [4,3,2,2,3] -> [0,0,3,3,0]
// [2,3,2,1,4] -> [3,4,4,4,0]
// [9,7,6,7,6,9] -> [0,9,7,9,9,0]