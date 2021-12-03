"""
:type height: List[int]
:rtype: int
"""
class Solution(object):

        
    def maxArea(self, height):
        pointerA = 0
        pointerB = len(height)-1
        sumArea = -1
        
        while pointerA <= pointerB :
            tempArea = min(height[pointerA], height[pointerB]) * (pointerB-pointerA)
            if tempArea > sumArea:
                sumArea = tempArea
            if height[pointerA] < height[pointerB]:
                pointerA += 1
            else:
                pointerB -= 1
        return sumArea