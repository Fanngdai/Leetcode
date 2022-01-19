class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rtn = new ArrayList<>();
        combinationSum3Helper(rtn, new ArrayList<>(), 1, k, n);
        return rtn;
    }
    
    private void combinationSum3Helper(List<List<Integer>> rtn, List<Integer> combo, int start, int k, int sum) {
        if(sum == 0 && combo.size() == k) {
            rtn.add(new ArrayList<Integer>(combo));
            return;
        } else if(sum <= 0 || combo.size() >= k) {
            return;
        }
        
        for(int i=start; i<10; i++) {
            combo.add(i);
            combinationSum3Helper(rtn, combo, i+1, k, sum-i);
            combo.remove(combo.size()-1);
        }
    }
}