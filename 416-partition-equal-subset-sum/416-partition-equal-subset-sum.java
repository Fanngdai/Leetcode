class Solution {
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if(sum%2 == 1)
            return false;
        Set<Integer> set = new HashSet<>();
        return findSum(nums, sum/2, 0, set);
    }
    
    private int getSum(int[] nums) {
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        return sum;
    }
    
    private boolean findSum(int[] nums, int sum, int index, Set<Integer> set) {
        if(sum == 0) {
            return true;
        } else if(index >= nums.length || sum < 0) {
            return false;
        }
        
        set.add(sum);
        if(!set.contains(sum - nums[index]) && findSum(nums, sum - nums[index], index+1, set))
            return true;
        if((nums.length-1)*100 > sum && findSum(nums, sum, index+1, set))
            return true;
        
        return false;
    }
}

/*
 * Find the sum of entire array, if odd return false.
 * find sum which equals half of sum of array within array.
 * To do so, sum of array / 2 <- find value in array
 * dynamic program knapsack algo
 * set is used for time limit -> dynamic programming
 */

// [1,5,11,5]
// [1,2,3,5]
// [1]
// [1,5,11,5,2,4,2]
// [2]
// [3,3,3,4,5]
// [100,100,100,100,100,100,100,100]
// [100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100]
// [100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97]