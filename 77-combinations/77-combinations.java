class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rtn = new ArrayList<>();
        combineHelper(rtn, new ArrayList<>(), n, k, 1);
        return rtn;
    }
    
    private void combineHelper(List<List<Integer>> rtn, List<Integer> lst, int n, int k, int start) {
        if(lst.size() == k) {
            rtn.add(new ArrayList<>(lst));
            return;
        }
        
        for(int i=start; i<=n; i++) {
            lst.add(i);
            combineHelper(rtn, lst, n, k, i+1);
            lst.remove(lst.size()-1);
        }
    }
}