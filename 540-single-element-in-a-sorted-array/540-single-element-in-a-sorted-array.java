class Solution {
    public int singleNonDuplicate(int[] nums) {
        int nLen = nums.length;
        if(nLen == 1) return nums[0];
        
        int low = 0, high = nLen-1;
        
        while(low<high) {
            int mid = low + (high-low) / 2;
            int midVal = nums[mid];

            if(mid%2==1) {
                if(midVal == nums[mid-1]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                if(midVal == nums[mid+1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }
            }
        }
        
        return nums[low];
    }
}

/*
Cases
1.  mid = odd
    if mid val = left, the left side is the same val
    if not the same, the left side has the single digit
2. mid = even
    if right val is the same, the single val is on the right
    if it is not the same, it could be this value, or any value on the left
    
Each value can appear twice or once, the same value appearing more than 2 time is invalid
There is only one val which is not a duplicate

[1,2,2,3,3,4,4,5,5,6,6,7,7]
[1,1,2,2,3,3,4,4,5,5,6,6,7]
[1,1,2,2,3,3,4,5,5,6,6,7,7]
*/