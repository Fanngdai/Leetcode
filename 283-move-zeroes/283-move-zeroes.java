class Solution {
    public void moveZeroes(int[] nums) {
        // the non-zero values
        int count = 0;
        
        // loop through array O(n), count stops where the value is 0 until value is replaced
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        
        // count is now at where the 0's should begin
        for(int i=count; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}