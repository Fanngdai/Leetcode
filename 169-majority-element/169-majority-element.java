class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, val = nums[0], nLen = nums.length;
        
        for(int i=1; i<nLen; i++) {
            if(nums[i] == val) {
                count++;
            } else if(--count == 0) {
                val = nums[i];
                count = 1;
            }
        }
        
        return val;
    }
}

/*
Moore voting algorithm
*/