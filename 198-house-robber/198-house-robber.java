class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        
        int[] rtn = new int[len];
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