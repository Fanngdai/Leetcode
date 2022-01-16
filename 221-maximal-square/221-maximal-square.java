class Solution {
    public int maximalSquare(char[][] matrix) {
        int matrixRowLen = matrix.length, matrixColLen = matrix[0].length, max = 0;
        // must init this, bc char only holds one char... but what if the square is multiple digits?
        int[][] matrixInt = new int[matrixRowLen][matrixColLen];
        
        // go through first row & col bc. we don't need to calc those.
        // It'll always be the same values!
        for(int r=0; r<matrixRowLen; r++) {
            matrixInt[r][0] = matrix[r][0] == '0' ? 0 : 1;
            max = Math.max(max, matrixInt[r][0]);
        }
        
        for(int c=0; c<matrixColLen; c++) {
            matrixInt[0][c] = matrix[0][c] == '0' ? 0 : 1;
            max = Math.max(max, matrixInt[0][c]);
        }
        
        // Calculate squares here!
        for(int r=1; r<matrixRowLen; r++) {
            for(int c=1; c<matrixColLen; c++) {
                if(matrix[r][c] == '1') {
                    matrixInt[r][c] = maximalSquareHelper(matrixInt, r, c) + 1;
                    max = Math.max(max, matrixInt[r][c]);
                } else {
                    matrixInt[r][c] = 0;
                }
            }
        }
        
        // printBoard(matrixInt);
        return max*max;
    }
    
    /*
     * Get the min value from diagonal up left, left, up
     */
    private int maximalSquareHelper(int[][] matrix, int row, int col) {
        int matrixRowLen = matrix.length, matrixColLen = matrix[0].length, min = Integer.MAX_VALUE;
        int[][] directions = {{-1,-1},{0,-1},{-1,0}};
        
        for(int[] d: directions) {
            int tempR = row+d[0], tempC = col+d[1];
            min = Math.min(min, matrix[tempR][tempC]);
        }
        return min;
    }
    
    /*
     * For testing purposes
     */
    private void printBoard(int[][] matrix) {
        int matrixRowLen = matrix.length, matrixColLen = matrix[0].length;
        for(int r=0; r<matrixRowLen; r++) {
            for(int c=0; c<matrixColLen; c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println();
        }
    }
    
}

/*
[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
[["0","1"],["1","0"]]
[["1","1"],["1","1"]]
[["0"]]
[["1"]]
[["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"]]
[["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"]]
[["0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"]]
[["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]]
[["1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"]]
[["0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]]
[["0"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"]]
[["1"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"],["0"]]
[["1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","0"],["1","1","1","1","1","1","1","0"],["1","1","1","1","1","0","0","0"],["0","1","1","1","1","0","0","0"]]
 */