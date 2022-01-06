class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        Set<Integer> wordCountSet = new HashSet<>();
        
        for(String word: wordDict) {
            trie.insert(word);
            wordCountSet.add(word.length());
        }
        
        return wordBreakHelper(s, trie, wordCountSet, new HashSet<>());
    }
    
    private boolean wordBreakHelper(String s, Trie trie, Set<Integer> wordCountSet, Set<String> wordSet) {
        if(s.equals("")) return true;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            if(!wordSet.contains(s.substring(i+1, s.length()))
               && trie.exist(sb.toString())) {
                wordSet.add(s.substring(i+1, s.length()));
                if(wordBreakHelper(s.substring(i+1,s.length()), trie, wordCountSet, wordSet)) {
                    return true;
                }
                // wordSet.remove(s.substring(i+1, s.length()));
            }
        }
        return false;
    }
}

class Trie {
    Trie[] root = new Trie[26];
    boolean end;
    
    public void insert(String word) {
        Trie temp = this;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(temp.root[index] == null) {
                temp.root[index] = new Trie();
            }
            temp = temp.root[index];
        }
        temp.end = true;
    }
    
    public boolean exist(String word) {
        Trie temp = this;
        char c;
        for(int i=0; i<word.length(); i++) {
            c = word.charAt(i);
            temp = temp.root[c-'a'];
            if(temp == null) {
                return false;
            }
        }
        return temp.end;
    }
}

// "bb"
// ["a","b","bbb","bbbb"]
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
// ["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]