class Solution {
    public int[] buildArray(int[] nums) {
        int[] rtn = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            rtn[i] = nums[nums[i]];
        }
        return rtn;
    }
}