class Solution {
    public int[][] construct2DArray(int[] original, int row, int col) {
        if(row*col != original.length) return new int[0][0];
        
        int[][] rtn = new int[row][col];
        int index = 0;
        
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                rtn[r][c] = original[index++];
            }
        }
        
        return rtn;
    }
}