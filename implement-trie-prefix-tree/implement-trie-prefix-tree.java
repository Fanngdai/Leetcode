class Node {
    boolean end = false;
    Node[] arr = new Node[26];
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        // loop through the word
        for(int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            // if the letter is not in there yet
            if(curr.arr[letter-'a'] == null) {
                Node temp = new Node();
                curr.arr[letter-'a'] = temp;
                curr = temp;
            } else {
                curr = curr.arr[letter-'a'];
            }
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        Node temp = leftOfWord(word);
        return temp == null ? false : temp.end;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = leftOfWord(prefix);
        return temp != null;
    }
    
    private Node leftOfWord(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            if(curr.arr[letter-'a'] == null)
                return null;
            curr = curr.arr[letter-'a'];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */