class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if nums == []:
            return 0
        return self.rec(nums, val, 0, len(nums)-1)
    
    def rec(self, nums, val, start, end):        
        if start == end and nums[start] != val:
            return 1
        elif start >= end:
            return 0
        else:
            if nums[start] == val:
                while nums[end] == val and start < end:
                    end -= 1
                    if start == end:
                        return 0
                nums[start], nums[end] = nums[end], nums[start]
        return self.rec(nums, val, start +1, end) + 1
        
        