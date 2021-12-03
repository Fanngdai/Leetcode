class Solution:
    def rec(self, x, n):
        if n == 1:
            return x
        elif n%2 != 0:
            return (self.rec(x,n//2) * self.rec(x,n//2+1))
        else:
            return (self.rec(x,n//2) * self.rec(x,n//2))
        
    def myPow(self, x: float, n: int) -> float:
        # return self.rec(x,n)
        return x**n