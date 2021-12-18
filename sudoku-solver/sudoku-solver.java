class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    
    private boolean solveSudokuHelper(char[][] board) {
        // loop through the entire board
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                // only add values if the value is . which means we need to replace it
                if(board[r][c] == '.') {
                    // the values being put in
                    for(char i='1'; i<='9'; i++) {
                        if(isValid(board, r, c, i)) {
                            // set the value to i
                            board[r][c] = i;
                            // if it is true, we will continue, otherwise, it will recursively backtrack
                            if(solveSudokuHelper(board)) return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char val) {
        for(int i=0; i<9; i++) {
            if(board[row][i] == val || board[i][col] == val
              || board[row/3*3+(i/3)][col/3*3+(i%3)] == val)
                return false;
        }
        return true;
    }
    
}