class Solution {
    public int firstMissingPositive(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i: nums) {
            if(i > 0) {
                minHeap.add(i);
            }
        }
        
        int rtn = 1;
        while(!minHeap.isEmpty()) {
            if(minHeap.poll() != rtn) {
                return rtn;
            }
            while(!minHeap.isEmpty() && minHeap.peek() == rtn) {
                minHeap.poll();
            }
            rtn++;
        }
        
        return rtn;
    }
    
    private int firstMissingPositiveWithSet(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0 && !set.contains(nums[i])) {
                minHeap.add(nums[i]);
                set.add(nums[i]);
            }
        }
        
        int rtn = 1;
        while(!minHeap.isEmpty()) {
            if(minHeap.poll() != rtn) {
                return rtn;
            }
            rtn++;
        }
        
        return rtn;
    }
}

/*
Logic: put in heap and start counting, we can also sort it.
I did the min Heap way. While it is not in the heap and is a pos number,
Add it

[0,2,2,1,1]
https://leetcode.com/submissions/detail/622618508/testcase/
*/