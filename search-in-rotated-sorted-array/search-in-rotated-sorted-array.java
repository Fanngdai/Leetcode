class Solution {
    public int search(int[] nums, int target) {
        return BST(nums, target, 0, nums.length-1);
    }
    
    private int BST(int[] nums, int target, int left, int right) {
        if(left > right || left == right && nums[left] != target) {
            return -1;
        } else if(left == right) {
            return left;
        } else if(nums[left] == target) {
            return left;
        } else if(nums[right] == target) {
            return right;
        }
        
        int mid = (right + left) / 2;
        int a = BST(nums, target, left+1, mid);
        int b = BST(nums, target, mid+1, right-1);
        
        return a==-1 ? b : a;
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