class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int numsLen = nums.length;
        // time complexity O(nlogn)
        Arrays.sort(nums);
        int val = nums[0] + nums[1] + nums[2];
        
        // O(n^2)
        for(int i=0; i<numsLen-2; i++) {
            int left = i+1, right = numsLen-1;
             
            while(left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                
                // current val is closer to target value
                if(Math.abs(target-currSum) < Math.abs(target-val)) {
                    // optimization
                    if(currSum == target) {
                        return currSum;
                    }
                    val = currSum;
                }
                
                if(currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            
            
        }
        
        return val;
        
    }
}

/*
[-1,2,1,-4]
1
[0,0,0]
1
[-2,0,0,1]
0
[0,0,0,5]
1
[0,0,0,5]
5
*/