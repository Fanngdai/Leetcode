class Solution {
    public void sortColors(int[] nums) {
        int[] counter = {0, 0};
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                nums[index++] = 0;
            } else {
                counter[nums[i]-1]++;
            }
        }
    
        for(int i=0; i<counter[0]; i++) {
            nums[index++] = 1;
        }
        for(int i=0; i<counter[1]; i++) {
            nums[index++] = 2;
        }
    }
}