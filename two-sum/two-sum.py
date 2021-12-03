"""
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

class Solution(object):
    def twoSumON2(self, nums, target):
        for index1, n1 in enumerate(nums):
            for index2, n2 in enumerate(nums):
                if(index1 == index2):
                    continue
                if(n1+n2==target):
                    return [index1,index2]
              
    '''
    Use a dictionary to keep track,
    If the value we are looking for was in the list, then
        we return the index
        get the required dictionary value,
        i stands for the index of current value
    else
        store the value in the array as key
        the index as value
    '''
    def twoSum(self, nums, target):
        required = {}
        for i in range(len(nums)):
            if target - nums[i] in required:
                return [required[target - nums[i]],i]
            else:
                required[nums[i]]=i
