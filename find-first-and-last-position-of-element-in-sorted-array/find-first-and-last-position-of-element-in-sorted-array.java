class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {-1,-1};
        }
        return binSearch(nums, target, 0, nums.length-1);
    }
    
    private int[] binSearch(int[] nums, int target, int left, int right) {
        int mid = (left+right)/2;
        
        if(left > right) {
            return new int[] {-1,-1};
        } else if(nums[mid] == target) {
            int start = mid, end = start;
            while(start>=0 && nums[start] == target) {
                    start--;
            }
            while(end<nums.length && nums[end] == target) {
                end++;
            }
            return new int[] {start+1, end-1};
        } else if (target < nums[mid]) {
            return binSearch(nums, target, left, mid-1);
        } else {
            return binSearch(nums, target, mid+1, right);
        }
    }
}