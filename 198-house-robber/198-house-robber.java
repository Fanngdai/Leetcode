class Solution {
    public int rob(int[] nums) {
        // return robRecursion(nums);
        
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i<len; i++) {
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }
        return Math.max(nums[len-2], nums[len-1]);
    }
    
    private int robRecursion(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int[] rtn = new int[len];
        // O(n)
        Arrays.fill(rtn, -1);
        robHelper(nums, rtn, 0, 0);
        robHelper(nums, rtn, 0, 1);
        return Math.max(rtn[len-1], rtn[len-2]);
    }
    
    private void robHelper(int[] nums, int[] rtn, int sum, int index) {
        if(index >= nums.length || sum + nums[index] <= rtn[index]) {
            return;
        }
        rtn[index] = sum + nums[index];
        robHelper(nums, rtn, rtn[index], index + 2);
        robHelper(nums, rtn, rtn[index], index + 3);
    }
}

/*
 * Start at 0 or 1
 * skip 1 or 2
 * dynamic programming
 *      if less, stop
 * 
 */