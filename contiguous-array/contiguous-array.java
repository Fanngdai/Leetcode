class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        counter.put(0, -1);
        int max = 0, count = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count --;
            } else {
                count++;
            }
            
            if(counter.containsKey(count)) {
                max = Math.max(max, i - counter.get(count));
            } else {
                counter.put(count, i);
            }
        }
        
        return max;
    }
}


