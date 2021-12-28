class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        
        int rowSize = board.length, colSize = board[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        List<String> rtn = new ArrayList<>();
        
        for(int r=0; r<rowSize; r++) {
            for(int c=0; c<colSize; c++) {
                findWordsHelper(board, "", r, c, trie, visited, rtn);
            }
        }
        
        return rtn;
    }
    
    private void findWordsHelper(char[][] board, String word, int row, int col, Trie trie, boolean[][] visited, List<String> rtn) {
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col]) {
            return;
        }
        
        word += board[row][col];
        
        if(!trie.startsWith(word)) {
            return;
        } else if(trie.search(word)) {
            rtn.add(word);
        }
        
        visited[row][col] = true;
        findWordsHelper(board, word, row-1, col, trie, visited, rtn);
        findWordsHelper(board, word, row+1, col, trie, visited, rtn);
        findWordsHelper(board, word, row, col-1, trie, visited, rtn);
        findWordsHelper(board, word, row, col+1, trie, visited, rtn);
        visited[row][col] = false;
    }
}
 
class Trie {
    public Trie[] root = new Trie[26];
    boolean end = false;
    
    public void insert(String word) {
        Trie temp = this;
        for(char c: word.toCharArray()) {
            if(temp.root[c-'a'] == null){
                temp.root[c-'a'] = new Trie();
            }
            temp = temp.root[c-'a'];
        }
        temp.end = true;
    }
 
    public boolean search(String word) {
        Trie trie = getTrie(word);
        if(trie.end) {
            trie.end = false;
            return true;
        } else {
            return false;
        }
    }
 
    /*
     * Make sure word given is part of a prefix
     */
    public boolean startsWith(String prefix){
        Trie trie = getTrie(prefix);
        return trie != null;
    }
    
    private Trie getTrie(String word) {
        Trie temp = this;
        for(char c: word.toCharArray()){
            if(temp.root[c-'a'] == null)
                return null;
            temp = temp.root[c-'a'];
        }
        return temp;
    }
}

// [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
// ["oath","pea","eat","rain"]
// [["a","b"],["c","d"]]
// ["abcb"]
// [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
// ["oa","oaa"]