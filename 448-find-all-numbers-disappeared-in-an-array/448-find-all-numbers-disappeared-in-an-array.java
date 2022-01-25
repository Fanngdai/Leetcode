class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int nLen = nums.length;
        
        // swap the values in place, while this current value should not be there but also if the value at that
        // location is already at that location then stop.
        for(int i=0; i<nLen; i++) {
            while(nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        // look for val that is not supposed to be there
        List<Integer> rtn = new ArrayList<>();
        for(int i=0; i<nLen; i++) {
            if(nums[i] != i+1) {
                rtn.add(i+1);
            }   
        }
        
        return rtn;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

/*
Logic:
    I can sort it O(nlogn)
    
    I can also swap it O(n)
*/