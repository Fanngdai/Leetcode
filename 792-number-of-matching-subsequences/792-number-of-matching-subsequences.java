class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0, sLen = s.length();
        Map<String, Boolean> inWords = new HashMap<>();
        
        for(String w: words) {
            if(inWords.containsKey(w)) {
                if(inWords.get(w)) {
                    count++;
                }
                continue;
            }
            
            int wIndex = 0;
            for(int i=0; i<sLen; i++) {
                if(s.charAt(i) == w.charAt(wIndex)) {
                    wIndex++;
                    if(wIndex == w.length()) {
                        count++;
                        inWords.put(w, true);
                        break;
                    }
                }
                inWords.put(w, false);
            }
        }
        
        return count;
    }
}