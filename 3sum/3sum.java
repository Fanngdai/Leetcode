class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++) {            
            int left = i+1, right = nums.length-1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    
                    do {
                        left++;
                    } while(left < right && nums[left] == nums[left-1]);
                    
                    do {
                        right--;
                    } while(left < right && nums[right] == nums[right+1]);
                } else if(sum < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }
    
}

// [0,0,0,0]