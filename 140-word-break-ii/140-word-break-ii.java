class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(int i=0; i<wordDict.size(); i++) {
            trie.insert(wordDict.get(i));
        }
        
        List<String> rtn = new ArrayList<>();
        trie.search(rtn, new StringBuilder(), s, 0);
        
        return rtn;
    }
}

class Trie {
    Trie[] root;
    boolean end;
    
    public Trie() {
        root = new Trie[26];
        end = false;
    }
    
    public void insert(String word) {
        Trie trie = this;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(trie.root[index] == null) {
                trie.root[index] = new Trie();
            }
            trie = trie.root[index];
        }
        trie.end = true;
    }
    
    public void search(List<String> lst, StringBuilder sb, String word, int start) {
        int wLen = word.length(), sbLen = sb.length();
        
        if(start == wLen) {
            sb.deleteCharAt(sbLen - 1);
            lst.add(sb.toString());
            return;
        }
        
        Trie trie = this;
        for(int i=start; i<wLen; i++) {
            int index = word.charAt(i)-'a';
            if(trie.root[index] == null) {
                return;
            }
            if(trie.root[index].end) {
                int sLen = sbLen;
                sb.append(word.substring(start, i+1) + " ");
                search(lst, sb, word, i+1);
                sb.setLength(sLen);
            }
            trie = trie.root[index];
        }
    }
}