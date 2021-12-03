class Solution:
    def isValid(self, s: str) -> bool:
        dictionary = {"(":")","{":"}","[":"]"}
        stack = []
        
        for c in s:
            if c in dictionary:
                stack.append(dictionary.get(c))
            elif not stack or stack.pop() != c:
                return False
        
        if stack:
            return False
        return True