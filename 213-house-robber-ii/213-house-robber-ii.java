class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if(len==1) {
            return nums[0];
        }
        
        return Math.max(robHelper(nums,0,len-1), robHelper(nums,1,len));
    }
    
    private int robHelper(int[]nums, int start, int end) {
        int with = nums[start], without = 0;
        for(int i=start+1; i<end; i++) {
            int tempWith = without + nums[i];
            without = Math.max(without, with);
            with = tempWith;
        }
        return Math.max(with, without);
    }
}

/*
 * Start from 0, end at len -1
 * Start from 1, end at len
 * 
 * Logic
 * go in loop, the first value is 0, the secone is whatever is at nums[1]
 * take the greatest value iterating adds so, i -> nums[0] + nums[2] + nums[4]
 *  but in the case it is 4 1 1 4, it would add -> nums[0] + nums[2] and compare to nums[0] + nums[2]
 */