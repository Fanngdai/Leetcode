"""
:type height: List[int]
:rtype: int
"""
class Solution(object):
    
    def trap(self, height):
        lPointer = 0
        rPointer = len(height) - 1
        lMax = height[lPointer]
        rMax = height[rPointer]
        sum = 0
        
        while lPointer < rPointer:
            # Compare & update if new val >= previous val
            if height[lPointer] <= height[rPointer]:
                lPointer += 1
                
                # min(lMax & rMax) - current pointer (ignore neg val)
                temp = min(lMax, rMax) - height[lPointer]
                if temp > 0:
                    sum += temp
                
                # check if currect value is > left max
                if height[lPointer] > lMax:
                    lMax = height[lPointer]
            else:
                rPointer -= 1
                
                temp = min(lMax, rMax) - height[rPointer]
                if temp > 0:
                    sum += temp
                
                if height[rPointer] > rMax:
                    rMax = height[rPointer]
        
        return sum