class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Use max heap
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        
        // loop through all the values
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                int currVal = matrix[r][c];
                // if queue does not have all the values, add the value
                if(queue.size() < k) {
                    queue.add(currVal);
                } else if(queue.peek() > currVal) {
                    // if the value we have rn is smaller, pop the greatest value, add the smaller value
                    queue.poll();
                    queue.add(currVal);
                } else {
                    // we are looping through the col, if the value is larger, continue, bc the rows are sorted
                    continue;
                }
            }
        }
        
        return queue.poll();
    }
}