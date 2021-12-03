class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        rtn = strs[0]
        # loop through all the strings
        for i in strs:
            rtn = rtn[:min(len(rtn),len(i))]
            for j in range(len(rtn)):
                if rtn[j] != i[j]:
                    rtn = i[:j]
                    break
                
        return rtn