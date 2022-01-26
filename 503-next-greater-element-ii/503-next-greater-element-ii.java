class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int nLen = nums.length;

        Stack<Integer> stack = new Stack();
        int[] rtn = new int[nLen];
        Arrays.fill(rtn, -1);
        
        for(int i=0; i<2*nLen; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%nLen]) {
                rtn[stack.pop()] = nums[i%nLen];
            }
            
            if(i<nLen) stack.push(i);
        }
            
        return rtn;
    }
}
