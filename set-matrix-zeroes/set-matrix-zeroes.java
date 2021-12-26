class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        
        // check if all rows, if 0 then later we have to set whole col to 0
        for(int r=0; r<matrix.length; r++) {
            if(matrix[r][0] == 0) {
                col = true;
                break;
            }
        }
        
        // check if all cols, if 0 then later we have to set whole row to 0
        for(int c=0; c<matrix[0].length; c++) {
            if(matrix[0][c] == 0) {
                row = true;
                break;
            }
        }
        
        // look for 0's everywhere but the first row & col, set first row & col to 0 if found
        for(int r=1; r<matrix.length; r++) {
            for(int c=1; c<matrix[0].length; c++) {
                if(matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        // if 0 is found in first row, set whole col to 0, but not at 0,0
        for(int r=1; r<matrix.length; r++) {
            if(matrix[r][0] == 0) {
                for(int c=1; c<matrix[0].length; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        // if 0 is found in first col, set whole row to 0, but not at 0,0
        for(int c=1; c<matrix[0].length; c++) {
            if(matrix[0][c] == 0) {
                for(int r=1; r<matrix.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        // set first row to 0
        if(row) {
            for(int c=0; c<matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
        
        // set first col to 0
        if(col) {
            for(int r=0; r<matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
        
    }
}