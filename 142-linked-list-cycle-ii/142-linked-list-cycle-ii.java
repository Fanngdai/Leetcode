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
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode walker = head, runner = head;
        
        // walk do the walk, run do the run
        do {
            walker = walker.next;
            runner = runner.next == null ? null : runner.next.next;
        } while(runner != null && runner != walker);
        
        // no cycle
        if(runner == null) {
            return null;
        }
        
        runner = head;
        while(runner != walker) {
            runner = runner.next;
            walker = walker.next;
        }
        
        return walker;
    }
}

/*
 * tortoise hare algorithm
 * tortoise walk the walk -> 1 step at a time
 * hare run the run -> 2 steps at a time
 *
 * then set one of the elements to start, and each will go one by one.
 * 
 * if they end at same node at some point, there is a cycle.
 * if no cycle, runner will be at null first
 */