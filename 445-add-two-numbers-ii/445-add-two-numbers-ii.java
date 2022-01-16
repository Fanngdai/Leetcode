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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        } else if(l1.val == 0 || l2.val == 0) {
            return l1.val == 0 ? l2 : l1;
        }
        
        // return addTwoNumbersStackoverflow(l1, l2);
        return addTwoNumbersStack(l1, l2);
        
    }
    
    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        // push to stack
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int remainder = 0, val1, val2, sum;
        ListNode head = null, next;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            val1 = stack1.isEmpty() ? 0 : stack1.pop();
            val2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = val1 + val2 + remainder;
            remainder = sum / 10;
            // can optimize this space by using one of the stacks listnode, so stack will store list node instead of int
            next = head;
            head = new ListNode(sum % 10);
            head.next = next;
        }
        
        if(remainder != 0) {
            next = head;
            head = new ListNode(remainder);
            head.next = next;
        }
        
        return head;
    }
    
    private ListNode addTwoNumbersStackoverflow(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        } else if(l1.val == 0 || l2.val == 0) {
            return l1.val == 0 ? l2 : l1;
        }
        
        ListNode sumNode = l1, rtn = l1;
        int first = 0, second = 0;
        
        while(l1 != null) {
            first = first * 10 + l1.val;
            
            // so that when we add, it will not mess up
            if(l1.next == null) {
                l1.next = l2;
                break;
            }
            
            l1 = l1.next;
        }
        
        while(l2 != null) {
            second = second * 10 + l2.val;
            l2 = l2.next;
        }
        
        int sum = first + second;
        System.out.println(sum);
        int numDigits = (int)Math.pow(10, (int)Math.floor(Math.log10(sum)));
        
        while(numDigits != 0) {
            sumNode.val = sum / numDigits;
            sum %= numDigits;
            numDigits /= 10;
            if(numDigits == 0)
                sumNode.next = null;
            sumNode = sumNode.next;
        }
        
        return rtn;
    }
}

/*
    Ways to solve:
    1. add them all up prevVal * 10 + l1.val
       then add them put in one of the 2 linkedlist
       Does not cover stackoverflow
    2. Put in stack and add 
       time     O(l1+l2)
       space    O(l1+l2)
    3. recursion?
    
    
    [7,2,4,3]
    [5,6,4]
    [2,4,3]
    [5,6,4]
    [0]
    [0]
    [9]
    [0]
    [1,9]
    [1]
    [9,9,9]
    [9,9,9]
    [3,9,9,9,9,9,9,9,9,9]
    [7]
    [9,9,9,9,9,9,9,9,9,9]
    [9,9,9,9,9,9,9,9,9,9]
*/