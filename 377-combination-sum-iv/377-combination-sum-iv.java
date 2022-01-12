class Solution {
    public int combinationSum4(int[] nums, int target) {
        return bottomUp(nums, target);
    }
    
    private int topDown(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<=target; i++) {
            for(int n: nums) {
                if(n <= i) dp[i] += dp[i-n];
            }
        }
        return dp[target];
    }
    
    private int bottomUp(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=0; i<=target; i++) {
            if(dp[i] == 0) continue;
            for(int n: nums) {
                if(n+i <= target) dp[i+n] += dp[i];
            }
        }
        return dp[target];
    }
}