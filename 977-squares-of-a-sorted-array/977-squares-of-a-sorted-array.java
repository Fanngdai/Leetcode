class Solution {
    public int[] sortedSquares(int[] nums) {
        int nLen = nums.length, left = 0, right = nums.length - 1;
        int[] rtn = new int[nLen];
        
        for(int i=nLen-1; i>=0; i--) {
            if(nums[right] > nums[left] * -1) {
                rtn[i] = (int)Math.pow(nums[right--], 2);
            } else {
                rtn[i] = (int)Math.pow(nums[left++], 2);
            }
        }
        
        return rtn;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int[] sortedSquaresMyWay(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

/*
[-4,-1,0,3,10]
[-7,-3,2,3,11]
[-5,-3,-2,-1]
[-5,-3,1,2]
[1]
[-1]
*/