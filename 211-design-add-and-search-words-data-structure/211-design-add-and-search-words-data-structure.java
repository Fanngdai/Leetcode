class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(trie, word);
    }
}

class Trie {
    Trie[] root;
    boolean end;
    
    public Trie() {
        root = new Trie[26];
    }
    
    public void insert(String word) {
        Trie temp = this;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(temp.root[c-'a'] == null) {
                temp.root[c-'a'] = new Trie();
            }
            temp = temp.root[c-'a'];
        }
        temp.end = true;
    }
    
    public boolean search(Trie temp, String word) {
        int wordLength = word.length();
        
        for(int i=0; i<wordLength; i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(int j=0; j<26; j++) {
                    if(temp.root[j] != null &&  search(temp.root[j], word.substring(i+1,wordLength))) {
                        return true;
                    }
                }
                return false;
            } else if(temp.root[c-'a'] == null) {
                return false;
            }
            temp = temp.root[c-'a'];
        }
        return temp.end;
    }
    
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
// [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]