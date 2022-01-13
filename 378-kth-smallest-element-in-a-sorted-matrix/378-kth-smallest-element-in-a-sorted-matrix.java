class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[0].length; c++) {
                int currVal = matrix[r][c];
                if(queue.size() < k) {
                    queue.add(currVal);
                } else if(queue.peek() > currVal) {
                    queue.poll();
                    queue.add(currVal);
                }
            }
        }
        
        return queue.poll();
    }
}