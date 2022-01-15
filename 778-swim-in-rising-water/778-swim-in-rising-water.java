class Solution {
    
    public int swimInWater(int[][] grid) {
        int gridLen = grid.length, rtn = grid[0][0], row = 0, col = 0;
        grid[0][0] = Integer.MAX_VALUE;
        
        // O(n^2)
        Queue<Integer> minHeap = new PriorityQueue<>();
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        
        // O(n^2) keep going until we reach the the bottom right corner
        while(row != gridLen-1 || col != gridLen-1) {
            
            // add all directions into heap
            for(int[] d: directions) {
                int tempRow = row + d[0], tempCol = col + d[1];
                // not valid index
                if(tempRow < 0 || tempRow > gridLen-1 || tempCol < 0 
                   || tempCol > gridLen-1 || grid[tempRow][tempCol] > 2500)
                    continue;
                minHeap.add((grid[tempRow][tempCol]<<12) ^ (tempRow<<6) ^ tempCol);
                grid[tempRow][tempCol] = Integer.MAX_VALUE;
            }
            
            // update the next val
            // int tempVal = minHeap.poll();
            rtn = Math.max(rtn, minHeap.peek() >> 12);
            row = minHeap.peek() >> 6 & 63;
            col = minHeap.poll() & 63;
        }
        return rtn;
    }

}

/*
    the grid is a square, and max it can be is 50 which is 6 bits max
    Each grid is 2500 max 12 bits
    
    since it is min heap, and we want the value to be sorted, put the value of grid as MSB
*/