class Solution {
    /*
     * counter      product all the way until you reach 0
     * counter2     product all the way until you reach 0, but starts after the first neg val
     * max          max to be returned 
     *
     * If only one value, return that one value
     */
    public int maxProduct(int[] nums) {
        int counter = nums[0], counter2 = 1, max = nums[0];
        boolean zeroFound = true;
        
        for(int i=1; i<nums.length; i++) {            
            // prev was a 0, so set this val to next.
            if(counter == 0) {
                counter = nums[i];
                zeroFound = true;
            } else {
                // counter2 always equals the value after the first neg value
                if(counter < 0 && zeroFound) {
                    counter2 = 1;
                    zeroFound = false;
                }
                counter *= nums[i];
                counter2 *= nums[i];
                
                if(counter > max)
                    max = counter;
                if(counter2 > max)
                    max = counter2;
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }
    
    private int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for(int i: nums) {
            max = Math.max(max, i);
        }
        return max;
    }
}

// [-2,-5,-2,-4,-3,-1,-2,-4,-6,-7,-5,-6,-7]
// [2,3,-2,4]
// [-2,0,-1]
// [-2]
// [0,2]
// [2,-5,-2,-4,3]
// [1,0,-1,2,3,-5,-2]
// [0,2,3,4,6]