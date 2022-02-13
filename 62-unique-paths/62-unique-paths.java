class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int r=0; r<m; r++) {
            for(int c=1; c<n; c++) {
                dp[c] += dp[c-1];
            }
        }
        
        return dp[n-1];
    }
}