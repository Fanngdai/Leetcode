class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> rtn = new ArrayList<>();
        subsets(nums, 0, rtn, new ArrayList<>());
        return rtn;
    }
    
    private void subsets(int[] nums, int start, List<List<Integer>> rtn, List<Integer> lst) {
        rtn.add(new ArrayList<>(lst));

        int numsLen = nums.length;
        for(int i=start; i<numsLen; i++) {
            if(i != start && nums[i] == nums[i-1])
                continue;
            lst.add(nums[i]);
            subsets(nums, i+1, rtn, lst);
            lst.remove(lst.size()-1);
        }
    }
}