class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rtn = new ArrayList<>();
        
        combinationSumHelper(candidates, target, rtn, new ArrayList<>(), 0, 0);
        
        return rtn;
    }
    
    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> rtn, List<Integer> lst, int sum, int start) {
        if(sum == target) {
            rtn.add(new ArrayList<>(lst));
            return;
        }
        
        for(int i=start; i<candidates.length; i++) {
            int val = candidates[i];
            if(sum + val <= target) {
                lst.add(val);
                combinationSumHelper(candidates, target, rtn, lst, sum+val, i);
                lst.remove(lst.size()-1);
            }
        }
    }
    
}