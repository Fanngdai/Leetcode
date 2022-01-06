class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String s: words) {
            trie.insert(s);
        }
        
        return trie.findLongest(trie);
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
    
    public String findLongest(Trie trie) {
        String maxString = "", str = "";
        for(int i=0; i<26; i++) {
            if(trie.root[i] != null && trie.root[i].end) {
                str = (char)(i+'a') + findLongest(trie.root[i]);
                maxString = str.length() > maxString.length() ? str : maxString;
            }
        }
        return maxString;
    }
}