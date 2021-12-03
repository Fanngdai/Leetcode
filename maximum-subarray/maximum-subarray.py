class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        final = temp = -99999
        for n in nums:
            temp += n
            if temp > final:
                final = temp
            if n > temp:
                temp = n
            if n > final:
                final = temp = n
        return final

'''
final keeps the max, always!

temp keeps the max as we are adding
so, when final finds max, temp will too
but temp keeps adding

Now, if we are iterating and the value is temp < n < final
then temp will be replace with n, but final will not.
'''