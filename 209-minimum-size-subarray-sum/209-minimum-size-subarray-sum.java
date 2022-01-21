class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // time O(n) space O(1)
        int nLen = nums.length, rtn = Integer.MAX_VALUE, sum = 0, behind = 0;
        
        for(int ahead=0; ahead<nLen; ahead++) {
            sum += nums[ahead];
            
            while(sum>=target) {
                rtn = Math.min(rtn, ahead-behind+1);
                if(rtn == 1) return rtn;
                sum -= nums[behind++];
            }
        }
        
        return rtn == Integer.MAX_VALUE ? 0 : rtn;
    }

    
    // time O(n) space O(n)
    private int usingQueue(int target, int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int nLen = nums.length, rtn = Integer.MAX_VALUE, sum = 0;
        
        for(int i=0; i<nLen; i++) {
            sum += nums[i];
            queue.add(nums[i]);
            
            while(sum>=target) {
                rtn = Math.min(rtn, queue.size());
                if(rtn == 1) return rtn;
                sum -= queue.poll();
            }
        }
        
        return rtn == Integer.MAX_VALUE ? 0 : rtn;
    }
}

/*
Logic:
    Find continuous array which is greater or equal to target
    
*/