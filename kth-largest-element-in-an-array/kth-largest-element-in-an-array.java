class Solution {
    public int findKthLargest(int[] nums, int k) {
        int rtn = -1, left = 0, right = nums.length-1;
        k = nums.length-k;
        
        while(rtn == -1 || rtn != k) {
            rtn = partition(nums,left,right,k);
            if(rtn < k) {
                left = rtn+1;
            } else {
                right = rtn - 1;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int left, int right, int k) {
        if(left>=right) {
            return left;
        } else {
            int end = right;
            while(left != right && nums[left]<=nums[end]) {
                left++;
            }
            while(left<right && nums[right]>nums[end]) {
                right--;
            }
            swap(nums,left,right);
            return partition(nums,left,right,k);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}

