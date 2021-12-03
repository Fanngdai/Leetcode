class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        indexS = len(s) - 1
        indexT = len(t) - 1

        while indexS >= 0 or indexT >= 0:
            counter = 0
            while s[indexS] == '#' or counter > 0:
                if s[indexS] == '#':
                    counter += 1
                else:
                    counter -= 1
                indexS -= 1
                if indexS < 0:
                    break
                
            counter = 0
            while t[indexT] == '#' or counter > 0:
                if t[indexT] == '#':
                    counter += 1
                else:
                    counter -= 1
                indexT -= 1
                if indexT < 0:
                    break
            
            if indexS < 0 and indexT < 0:
                return True
            elif indexS < 0 or indexT < 0 or s[indexS] != t[indexT]:
                return False
            
            indexS -= 1
            indexT -= 1
                
        return True
