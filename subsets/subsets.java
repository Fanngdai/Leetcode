class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        List<Integer> lst = new ArrayList<>(); 
        subsets(lst, rtn, 0, nums);
        return rtn;
    }
    
    private void subsets(List<Integer> lst, List<List<Integer>> rtn, int skip, int[] nums) {
        rtn.add(new ArrayList<>(lst));
        for(int i=skip; i<nums.length; i++) {
            lst.add(nums[i]);
            subsets(lst, rtn, i+1, nums);
            lst.remove(lst.size()-1);
        }
    }
}

/*
 * Order of result does not matter
 */

// [1,2,3]
// [0]
// [1,2,3,4,5,6,7,8,10,0]