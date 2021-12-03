"""
:type s: str
:rtype: int
"""
class Solution(object):

    def romanToInt1(self, s):
        sum = 0
        length = len(s)
        
        for i in range(length):
            if (i+1 < length) and (intVal[s[i]] < intVal[s[i+1]]):
                sum -= intVal[s[i]]
            else:
                sum += intVal[s[i]]
            
        return sum

    def romanToIntRecursion(self, s, intVal):
        if s == "":
            return 0
        elif (len(s) > 1) and (intVal[s[0]] < intVal[s[1]]):
            return self.romanToIntRecursion(s[1:], intVal) - intVal[s[0]]
        else:
            return self.romanToIntRecursion(s[1:], intVal) + intVal[s[0]]
    
    def romanToIntRec(self, s):
        intVal = {'I': 1,
                  'V': 5,
                  'X': 10,
                  'L': 50,
                  'C': 100,
                  'D': 500,
                  'M': 1000}
        return self.romanToIntRecursion(s, intVal)
    
    def romanToInt(self, s):
        rom_val = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        int_val = 0
        for i in range(len(s)):
            if i > 0 and rom_val[s[i]] > rom_val[s[i - 1]]:
                int_val += rom_val[s[i]] - 2 * rom_val[s[i - 1]]
            else:
                int_val += rom_val[s[i]]
        return int_val