class Solution {
    public int findDuplicate(int[] nums) {
        int walker = 0, runner = 0;
        do{
            walker = nums[walker];
            runner = nums[nums[runner]];
        }while(nums[walker] != nums[runner]);
        
        runner = 0;
        
        while(nums[walker] != nums[runner]) {
            walker = nums[walker];
            runner = nums[runner];
        }
        
        return nums[walker];
    }
}

/*
 * tortoise hare algorithm
 */

// [1,3,4,2,2]
// [3,1,3,4,2]
// [1,1]
// [2,2,2,2,2]