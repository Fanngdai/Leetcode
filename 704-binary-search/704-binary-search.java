class Solution {
    public int search(int[] nums, int target) {
        // return searchRecursion(nums, target, 0, nums.length-1);
        return searchNotRecursion(nums, target);
    }
    
    private int searchNotRecursion(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while(left <= right) {
            int mid = (left+right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                // go right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int searchRecursion(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        
        int mid = (left+right) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] < target) {
            return searchRecursion(nums, target, mid+1, right);
        } else {
            return searchRecursion(nums, target, left, mid-1);
        }
    }
}