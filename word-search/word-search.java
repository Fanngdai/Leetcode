class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if(existHelper(board, row, col, word, 1, new Stack<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*
     * If set contains
     * If row < 0, col < 0, row >= board.length, col >= board[0].length
     */
    private boolean existHelper(char[][] board, int row, int col, String word, int wordIndex, Stack<String> stack) {
        if(stack.contains(row+","+col)) {
            return false;
        } else if(wordIndex == word.length()) {
            // System.out.println("###");
            // for(String i: stack)
            //     System.out.println(i);
            return true;
        }
        stack.add(row+","+col);
        
        char c = word.charAt(wordIndex++);
        
        if(row-1 >= 0 && board[row-1][col] == c) {
            if(existHelper(board, row-1, col, word, wordIndex, stack))
                return true;
        }
        if(row+1 < board.length && board[row+1][col] == c) {
            if(existHelper(board, row+1, col, word, wordIndex, stack))
                return true;
        }
        if(col-1 >= 0 && board[row][col-1] == c) {
            if(existHelper(board, row, col-1, word, wordIndex, stack))
                return true;
        }
        if(col+1 < board[0].length && board[row][col+1] == c) {
            if(existHelper(board, row, col+1, word, wordIndex, stack))
                return true;
        }
        stack.pop();
        return false;
    }
}

// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
// "ABCCED"
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
// "SEE"
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
// "ABCB"
// [["a","a","a","a"],["a","a","a","a"],["a","a","a","a"]]
// "aaaaaaaaaaaaa"