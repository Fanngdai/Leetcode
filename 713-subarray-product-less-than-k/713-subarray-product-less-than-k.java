class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        
        int nLen = nums.length, rtn = 0, behind = 0, sum = 1;
        
        for(int ahead = 0; ahead < nLen; ahead++) {
            sum *= nums[ahead];
            
            while(sum >= k) {
                sum /= nums[behind++];
            }
            
            rtn += ahead-behind+1;
        }
        
        return rtn;
    }
}

/*
Logic
    No product will be LESS than 1 - base case
    
[1,1,1,1,1,1,1,1,1,1,1]
5
*/