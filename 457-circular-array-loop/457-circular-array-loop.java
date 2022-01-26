class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int slow = 0, fast = 0, nLen = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nLen; i++) {
            nums[i] %= nLen;
        }
        
        for(int i=0; i<nLen; i++) {
            if(set.contains(i)) continue;
            set.add(i);
            if(circularArrayLoopHelper(nums, nLen, set, i)) return true;
        }
        
        return false;
    }
    
    private boolean circularArrayLoopHelper(int[] nums, int nLen, Set<Integer> set, int start) {
        int slow = start, fast = start;
        
        do {
            slow = (slow + nums[slow] + nLen) % nLen;
            if(set.contains(slow) && slow != start) return false;
            set.add(slow);
            fast = (fast + nums[fast] + nLen) % nLen;
            fast = (fast + nums[fast] + nLen) % nLen;
        } while(slow != fast);
        
        
        // self loop
        if((slow + nums[slow] + nLen) % nLen == fast) {
            return false;
        }
        
        boolean posNeg = nums[slow] > 0;
        // check for pos or neg
        do {
            slow = (slow + nums[slow] + nLen) % nLen;
            boolean flag = nums[slow] > 0;
            if(posNeg != flag) {
                return false;
            }
        } while(slow != fast);
        
        return true;
    }
}

/*
[3,1,2]
[-2,-3,-9]
[2,1,1,-1]
*/