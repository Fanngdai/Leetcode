class Solution {
    public boolean search(int[] nums, int target) {
        return BST(nums, target, 0, nums.length-1);
    }
    
    private boolean BST(int[] nums, int target, int left, int right) {
        if(left > right || left == right && nums[left] != target) {
            return false;
        } else if(left == right || nums[left] == target || nums[right] == target) {
            return true;
        }
        
        int mid = (right + left) / 2;
        int a = -1, b = -1;
        int l = nums[left], m = nums[mid], r = nums[right];
        
        // left < mid and left > target
        if(!(l < m && (l > target || m < target)) && BST(nums, target, left+1, mid)) {
            return true;
        }
        // mid < right and mid > target skip
        if(!(m < r && (m > target || r < target)) && BST(nums, target, mid+1, right-1)) {
            return true;
        }
        return false;
    }
}

// [4,5,6,7,0,1,2]
// 0
// [4,5,6,7,0,1,2]
// 3
// [1]
// 0
// [1]
// 1