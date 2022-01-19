class Solution {
    public int minDifference(int[] nums) {
        int numsLen = nums.length;
        if(numsLen <= 4) return 0;
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            min = Math.min(min, nums[numsLen-4+i]-nums[i]);
        }
        
        return min;
    }
}