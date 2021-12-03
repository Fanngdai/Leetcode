class Solution:
    '''
    maxCounter: The max longest substring
    list: make sure is all unique values, if not start removing like a queue until value is removed
    
    loop through the string. Add each char into list
    If char is in list, 
    '''
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxCounter = 0
        unique =[]
        for i in s:
            if i in unique:
                if len(unique) > maxCounter:
                    maxCounter = len(unique)
                # remove all until reach i
                while unique.pop(0) != i:
                    pass
            unique.append(i)
        if len(unique) > maxCounter:
            maxCounter = len(unique)
        return maxCounter