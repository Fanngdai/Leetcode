class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int wLen = words.length, minLen = Integer.MAX_VALUE;
        List<String> rtn = new ArrayList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        for(String w: words) {
            if(w.length() != 0) {
                set.add(w);
                minLen = Math.min(minLen, w.length());
            }
        }
        
        for(String w: words) {
            if(w.length() == minLen) {
                continue;
            }
            if(usingSet(set, w, minLen, visited)) {
                rtn.add(w);
            }
        }
        
        return rtn;
    }
    
    private boolean usingSet(Set<String> set, String word, int minLen, HashMap<String, Boolean> visited) {
        int wLen = word.length();
        if(visited.containsKey(word)) {
            return visited.get(word);
        } else if(wLen <= minLen) {
            visited.put(word, false);
            return false;
        }
        
        for(int i=minLen; i<=wLen-minLen; i++) {
            String tempStr = word.substring(0, i);
            if(set.contains(tempStr)) {
                tempStr = word.substring(i);
                if(set.contains(tempStr) || usingSet(set, tempStr, minLen, visited)) {
                    visited.put(word, true);
                    return true;
                }
            }
        }
        
        visited.put(word, false);
        return false;
    }
    
    // Works but Time Limit Exceeded
    public List<String> usingTrie(String[] words) {
        int wLen = words.length, minLen = Integer.MAX_VALUE;
        List<String> rtn = new ArrayList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        
        // init & add to trie
        Trie trie = new Trie();
        for(String w: words) {
            if(w.length() != 0) {
                trie.insert(w);
                minLen = Math.min(minLen, w.length());
            }
        }
        
        for(String w: words) {
            if(w.length() == minLen) {
                continue;
            }
            if(usingTrieHelper(trie, w, minLen, visited)) {
                rtn.add(w);
            }
        }
        
        return rtn;
    }
    
    private boolean usingTrieHelper(Trie trie, String word, int minLen, HashMap<String, Boolean> visited) {
        int wLen = word.length();
        if(visited.containsKey(word)) {
            return visited.get(word);
        } else if(wLen < minLen) {
            return false;
        }
        
        for(int i=minLen; i<=wLen-minLen; i++) {
            String tempStr = word.substring(0, i);
            if(trie.findString(tempStr) && (trie.findString(word.substring(i))
                || usingTrieHelper(trie, word.substring(i), minLen, visited))) {
                visited.put(word, true);
                return true;
            }
        }
        
        visited.put(word, false);
        return false;
    }
}

class Trie {
    Trie[] trie;
    boolean end;
    
    public Trie() {
        this.trie = new Trie[26];
    }
    
    public void insert(String word) {
        Trie root = this;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(root.trie[c-'a'] == null) {
                root.trie[c-'a'] = new Trie();
            }
            root = root.trie[c-'a'];
        }
        root.end = true;
    }
    
    public boolean findString(String word) {
        Trie root = this;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(root.trie[c-'a'] == null) {
                return false;
            }
            root = root.trie[c-'a'];
        }
        return root.end;
    }
}


/*
Can words be used more than once?
    yes
    I tried to recursively solve it using the findString in Trie
        But it won't work bc I am returning a list in the end...
        
["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat",""]
["cat","dog","catdog"]
["a","b","c","aa"]
["","a","b"]
*/