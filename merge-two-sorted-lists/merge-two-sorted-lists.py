# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
"""
:type l1: ListNode
:type l2: ListNode
:rtype: ListNode
"""
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        if l1 == None:
            return l2
        elif l2 == None:
            return l1
        # compare first value to see which is smaller, put smaller value as l1
        elif l2.val < l1.val:
            l1, l2 = l2, l1
        rtn = l1
            
        # compare l1.next to l2 if l1.next is greater, swap l1 and l2
        while (l1 != None) & (l2 != None):
            if l1.next == None:
                l1.next = l2
                break
            elif l2 == None:
                break
            elif l1.next.val > l2.val:
                l2, l1.next = l1.next, l2
            elif l1.next.val <= l2.val:
                l1 = l1.next
                
        return rtn
        