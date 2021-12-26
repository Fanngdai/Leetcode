class Solution {
    /*
     * 1,4,5,... dies
     * only 2&3 lives
     */
    public void gameOfLife(int[][] board) {
        int boardRow = board.length, boardCol = board[0].length;
        for(int r=0; r<boardRow; r++) {
            for(int c=0; c<boardCol; c++) {
                checkSurrounding(board, r, c, board[r][c]%10 == 1);
                // print(board, r, c);
            }    
        }
    }
    
    /*
     * Current is live, 1
     * change ALL the surroundings 10th digit to +1
     * if surroundings %10 == 1
     *
     * Checks the values at
     * right            row     col+1
     * bottom left      row+1   col-1
     * bottom           row+1   col
     * bottom right     row+1   col+1
     *
     * @param board     the board of the values.
     * 
     * @return          The amount of live surroundings.
     */
    private void checkSurrounding(int[][] board, int row, int col, boolean isLive) {
        int livingNeighbors = board[row][col] / 10;
        
        // right
        if(col+1<board[0].length) {
            // check if neighbor is live
            if(board[row][col+1]%10 == 1) {
                livingNeighbors++;
            }
            // change neighbors value
            if(isLive) {
                board[row][col+1] += 10;
            }
        }
        // bottom
        if(row+1<board.length) {
            // check if neighbor is live
            if(board[row+1][col]%10 == 1) {
                livingNeighbors++;
            }
            // change neighbors value
            if(isLive) {
                board[row+1][col] += 10;
            }
            
            // bottom left
            if(col-1>=0) {
                // check if neighbor is live
                if(board[row+1][col-1]%10 == 1) {
                    livingNeighbors++;
                }
                // change neighbors value
                if(isLive) {
                    board[row+1][col-1] += 10;
                }
            }
            
            // bottom right
            if(col+1<board[0].length) {
                // check if neighbor is live
                if(board[row+1][col+1]%10 == 1) {
                    livingNeighbors++;
                }
                // change neighbors value
                if(isLive) {
                    board[row+1][col+1] += 10;
                }
            }
        }
        
        if(isLive) {
            board[row][col] = (livingNeighbors < 2 || livingNeighbors > 3) ? 0 : 1;
        } else {
            board[row][col] = (livingNeighbors == 3) ? 1 : 0;
        }
    }
    
    /*
     * Print board for testing purposes
     */
    private void print(int[][] board, int row, int col) {
        System.out.println("###" + row + "\t" + col);
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[r].length; c++) {
                System.out.print(board[r][c] + "\t");
            }
            System.out.println();
        }
    }
    
}