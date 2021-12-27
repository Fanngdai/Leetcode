class Solution {
    HashMap<Integer, List<Integer>> hash;

    public Solution(int[] nums) {
        hash = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            if(hash.containsKey(val)) {
                hash.get(val).add(i);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                hash.put(val, lst);
            }
        }
    }
    
    public int pick(int target) {
        int len = hash.get(target).size();
        int ran = (int)(Math.random() * len);
        return hash.get(target).get(ran);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */