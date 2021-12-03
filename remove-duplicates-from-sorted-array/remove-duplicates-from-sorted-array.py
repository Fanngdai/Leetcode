"""
:type nums: List[int]
:rtype: int
"""
class Solution(object):
    def removeDuplicates(self, nums):
        pointer = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                pointer += 1
                nums[pointer] = nums[i]
        return pointer+1
        