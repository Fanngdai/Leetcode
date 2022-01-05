class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }
        
        int rtn = 0, left, right;
        while(!set.isEmpty()) {
            int value = set.iterator().next();
            set.remove(value);
            int counter = 1;
            left = value - 1;
            right = value + 1;
            
            while(set.contains(left) || set.contains(right)) {
                if(set.contains(left)) {
                    set.remove(left);
                    counter++;
                    left--;
                }
                if(set.contains(right)) {
                    set.remove(right);
                    counter++;
                    right++;
                }
            }
            rtn = Math.max(rtn, counter);
        }
        return rtn;
    }
}