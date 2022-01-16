class Solution {
    public int largestRectangleArea(int[] heights) {
        int heightsLen = heights.length, max = 0, area = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<heightsLen; i++) {
            int currHeight = heights[i];
            max = Math.max(max, currHeight);
            
            if(stack.isEmpty() || heights[stack.peek()] <= currHeight) {
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int popFromStack = stack.pop();
                // handle higher values within
                area = heights[popFromStack] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                max = Math.max(max, area);
            }

            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            // calc the min value for entire board or stack is min val up to the end of stack.
            area = heights[stack.pop()] * (stack.isEmpty() ? heightsLen : heightsLen-stack.peek()-1);
            max = Math.max(max, area);
        }
        
        return max;
    }
}

/*
[2,1,5,6,2,3]
[2,4]
[1]
[1,2,3,1,1,1,1,1,1]
[1,1,1,1,1,1,2,3,1,1,1,1]
[1,2,3,1,2]
[2,1,2]
[1,2,2]
[0,9]
[4,2,0,3,2,5]
*/