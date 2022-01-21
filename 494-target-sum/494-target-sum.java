class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWaysHelper(nums, target, 0 , 0);
    }
    
    private int findTargetSumWaysHelper(int[] nums, int target, int sum, int index) {
        if(index == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        return findTargetSumWaysHelper(nums, target, sum + nums[index], index + 1) + 
            findTargetSumWaysHelper(nums, target, sum - nums[index], index + 1);
    }
    
}