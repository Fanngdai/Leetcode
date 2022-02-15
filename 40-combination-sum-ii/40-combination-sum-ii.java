class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rtn = new ArrayList<>();
        combinationSum2Helper(candidates, target, 0, rtn, new ArrayList<>());
        return rtn;
    }
    
    private void combinationSum2Helper(int[] candidates, int remainder, int index,
                                        List<List<Integer>> rtn, List<Integer> lst) {
        int cLen = candidates.length;
        
        if(remainder == 0) {
            rtn.add(new ArrayList<>(lst));
            return;
        } else if(index == cLen || remainder < 0) {
            return;
        }
        
        for(int i=index; i<cLen; i++) {
            if(i != index && candidates[i] == candidates[i-1]) {
                continue;
            }
            lst.add(candidates[i]);
            combinationSum2Helper(candidates, remainder-candidates[i], i+1, rtn, lst);
            lst.remove(lst.size()-1);
        }
    }
}