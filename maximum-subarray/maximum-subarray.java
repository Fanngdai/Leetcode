class Solution {
    public int maxSubArray(int[] nums) {
        int counter = nums[0], max = nums[0];
        for(int i=1; i<nums.length; i++) {
            counter += nums[i];
            counter = Math.max(counter, nums[i]);
            max = Math.max(max, Math.max(counter, nums[i]));
        }
        return max;
    }
}