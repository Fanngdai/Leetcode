class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        
        for(int r=0; r<rLen; r++) {
            for(int c=0; c<cLen; c++) {
                if(matrix[r][c] == 0) {
                    queue.add(new Pair<>(r, c));
                } else {
                    matrix[r][c] = -1;
                }    
            }
        }
        
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty()) {
            int row = queue.peek().getKey(), col = queue.poll().getValue();
            for(int i=0; i<4; i++) {
                int tempRow = row+dir[i][0], tempCol = col+dir[i][1];
                if(tempRow >= 0 && tempRow < rLen && tempCol >= 0 && tempCol < cLen && matrix[tempRow][tempCol] < 0) {
                    matrix[tempRow][tempCol] = matrix[row][col] + 1;
                    queue.add(new Pair<>(tempRow, tempCol));
                }
            }
        }
        
        return matrix;
    }
}

/*
Logic
    Go through the entire matrix and add all the 0's into a queue.
        Turn all non-0's into -1's
    Add to queue and start going through it

[[0,0,0],[0,1,0],[0,0,0]]
[[0,0,0],[0,1,0],[1,1,1]]
[[1,1,1],[1,1,1],[1,1,0]]
*/