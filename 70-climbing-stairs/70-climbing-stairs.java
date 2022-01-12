class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 2, c = n;
        
        for(int i=3; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
            
        return c;
    }
}

/*
 * a -> first step
 * b -> second step
 * c is the third step...
 */