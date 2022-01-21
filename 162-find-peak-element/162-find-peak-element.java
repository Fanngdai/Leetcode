class Solution {
    public int findPeakElement(int[] nums) {
        int nLen = nums.length;
        if(nLen <= 1) return 0;
        
        int low = 0, high = nLen-1, mid;
        
        while(low<high) {
            mid = low + (high-low) / 2;
            
            if(mid == 0 && nums[mid] > nums[mid+1] || mid == nLen -1 && nums[mid] > nums[mid-1] ||
              mid != 0 && mid != nLen-1 && nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
                return mid;
            }
            
            // check the value at the left
            if(mid != 0 && nums[mid-1]>nums[mid]) {
                high = mid-1;
            } else {
                // check the value at the right, but also covers the case when both sides are larger
                low = mid+1;
            }
            
        }
        
        return low;
    }
    
}

/*
Compare the left side, if left side is larger, then move to the left
    do the same with the right side
    
Can the "peak" be at the start or end of the mt?
    yes
    
[1,2,3,1]
[1,2,1,3,5,6,4]
[1,2]
[1,6,5,4,3,2,1]
[5,4,3,4,5]
*/