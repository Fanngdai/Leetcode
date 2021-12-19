# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        tail = head
        
        # get to position where nodeToDeletePrior is n nodes away from end
        while n > 1:
            tail = tail.next
            n-=1
        
        # if the node is the head we want to remove
        if tail.next == None:
            return head.next
            
        # init the counter for the node to remove, but we want the node that is before
        nodeToDeletePrior = head
        tail = tail.next
        
        # Get to the node that you want to delete, but the one before that
        while tail.next != None:
            nodeToDeletePrior = nodeToDeletePrior.next
            tail = tail.next
            
        # Delete the node
        nodeToDeletePrior.next = nodeToDeletePrior.next.next
        
        return head
    
