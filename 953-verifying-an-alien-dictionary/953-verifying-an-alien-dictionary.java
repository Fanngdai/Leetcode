class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // put all letters in hash, by the position
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i=0; i<26; i++) {
            hash.put(order.charAt(i), i);
        }
        
        String prev = words[0], curr;
        // loop through and compare the prev and curr
        for(int i=1; i<words.length; i++) {
            curr = words[i];
            if(!compare(prev, curr, hash)) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
    
    private boolean compare(String prev, String curr, HashMap<Character, Integer> hash) {
        int index = 0;
        while(prev.charAt(index) == curr.charAt(index)) {
            index++;
            if(index == prev.length()) {
                return true;
            } else if(index == curr.length()) {
                return false;
            }
        }
        return hash.get(prev.charAt(index)) < hash.get(curr.charAt(index));
    }
}

/*
 * Put all char in hashmap, followed by the order       time: O(26)     space: O(52)
 * loop through words array                             O(wordArr * word)
 
 ["fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"]
"zkgwaverfimqxbnctdplsjyohu"

 */