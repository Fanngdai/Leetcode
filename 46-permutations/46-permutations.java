class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        
        permuteHelper(nums, rtn, visited, new ArrayList<>());
        return rtn;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> rtn, boolean[] visited, List<Integer> lst) {
        if(lst.size() == nums.length) {
            rtn.add(new ArrayList<>(lst));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            lst.add(nums[i]);
            permuteHelper(nums, rtn, visited, lst);
            lst.remove(lst.size()-1);
            visited[i] = false;
        }
    }
}