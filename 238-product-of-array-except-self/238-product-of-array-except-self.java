class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLen = nums.length;
        
        int[] temp = new int[arrLen];
        temp[0] = nums[0];
        
        // mulitple from the left
        for(int i=1; i<arrLen; i++) {
            temp[i] = temp[i-1] * nums[i];
        }
        
        int rightProd = nums[arrLen-1];
        temp[arrLen-1] = temp[arrLen-2];
        for(int i = arrLen-2; i>0; i--) {
            temp[i] = rightProd * temp[i-1];
            rightProd *= nums[i];
        }
        temp[0] = rightProd;
        
        return temp;
    }
}

/*
 * Multiple from the left, store in an array
 * Multiple from the right, store in a int variable.
 *      while looping, mutiple the variable to the array-1, which does not include the nums[i] val.
 */