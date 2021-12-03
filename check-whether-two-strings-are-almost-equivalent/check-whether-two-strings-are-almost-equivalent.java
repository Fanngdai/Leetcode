class Solution {
    
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> charCounter = new HashMap<>();
        
        for (int i = 0; i < word1.length(); i++) {
            char temp = word1.charAt(i);
            if(charCounter.containsKey(temp)) {
               charCounter.put(temp, charCounter.get(temp)+1);
            } else {
                charCounter.put(temp, 1);
            }
        }

        for (int i = 0; i < word2.length(); i++) {
            char temp = word2.charAt(i);
            if(charCounter.containsKey(temp)) {
                if(charCounter.get(temp) == -3)
                    return false;
               charCounter.put(temp, charCounter.get(temp)-1);
            } else {
                charCounter.put(temp, -1);
            }
        }
        
        for(int value : charCounter.values()) {
            if(value>3)
                return false;
        }
        
       return true;
   }
               
}