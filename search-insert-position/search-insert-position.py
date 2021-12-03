class Solution:
    def binSearch(self, nums, target, low, high):
        mid = (low + high) // 2
        
        if low >= high:
            if target <= nums[mid]:
                return 0 if mid < 0 else mid
            elif target > nums[mid]:
                return mid + 1
        elif nums[mid] == target:
            return mid
        elif nums[mid] > target:
            return self.binSearch(nums,target, low, mid-1)
        else:
            return self.binSearch(nums,target, mid+1, high)
    
    def searchInsert(self, nums: List[int], target: int) -> int:
        length = len(nums)-1
        return self.binSearch(nums, target, 0, length)