class Solution {
    public int arraySign(int[] nums) {
        boolean flag = true;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) return 0;
            if(nums[i] < 0) flag = !flag;
        }
        
        return flag ? 1 : -1;
    }
}