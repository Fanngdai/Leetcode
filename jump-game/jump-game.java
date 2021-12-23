class Solution {
    public boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }
    
    public boolean canJumpHelper(int[] nums, int index) {
        if(nums[index] == -1) return false;
        int tempSize = nums[index];
        nums[index] = -1;
        
        if(index == nums.length-1) return true;
        if(index > nums.length-1) return false;
        boolean flag = false;
        for(int i=1; i<=tempSize; i++)
            flag = flag || canJumpHelper(nums, index+i);
        return flag;
    }
}