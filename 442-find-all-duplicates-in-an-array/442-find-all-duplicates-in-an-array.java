class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int nLen = nums.length;
        
        for(int i=0; i<nLen; i++) {
            // value is not where it should be, the swapping val is not where it should be, the vals are not equal
            while(nums[i] != i+1 && nums[nums[i]-1] != nums[i] && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        List<Integer> rtn = new ArrayList<>();
        for(int i=0; i<nLen; i++) {
            if(nums[i] != i+1) {
                rtn.add(nums[i]);
            }   
        }
        
        return rtn;
    }
    
    private void swap(int[]nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}