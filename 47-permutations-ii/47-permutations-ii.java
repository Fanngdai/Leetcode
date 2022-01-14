class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // sort array to know if there are duplicate values
        Arrays.sort(nums);
        List<List<Integer>> rtn = new ArrayList<>();
        
        // used for when permuting
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        
        permuteUniqueHelper(nums, rtn, visited, new ArrayList<>());
        
        return rtn;
    }
    
    public void permuteUniqueHelper(int[] nums, List<List<Integer>> rtn, boolean[] visited, List<Integer> lst) {
        if(lst.size() == nums.length) {
            rtn.add(new ArrayList<>(lst));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            lst.add(nums[i]);
            permuteUniqueHelper(nums, rtn, visited, lst);
            lst.remove(lst.size()-1);
            visited[i] = false;
            
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}