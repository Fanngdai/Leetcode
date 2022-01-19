class Solution {
    public int numSplits(String s) {
        // return usingHashMap(s);
        return usingDP(s);
    }
    
    private int usingDP(String s) {
        Set<Character> set = new HashSet<>();
        int sLen = s.length(), rtn = 0;
        int[] dp1 = new int[sLen];
        int[] dp2 = new int[sLen];
        
        for(int i=0; i<sLen; i++) {
            set.add(s.charAt(i));
            dp1[i] = set.size();
        }
        
        set.clear();
        for(int i=sLen-1; i>=0; i--) {
            set.add(s.charAt(i));
            dp2[i] = set.size();
        }
        
        for(int i=1; i<sLen; i++) {
            if(dp1[i-1] == dp2[i]) {
                rtn++;
            }
        }

        return rtn;
    }
    
    private int usingHashMap(String s) {
        int rtn = 0;
        for(int i=1; i<s.length()-1; i++) {
            
            Set<Character> set1 = new HashSet<>();
            for(int j=0; j<i; j++) {
                set1.add(s.charAt(j));
            }

            Set<Character> set2 = new HashSet<>();
            for(int j=i; j<s.length(); j++) {
                set2.add(s.charAt(j));
            }
            
            if(set1.size() == set2.size()) {
                rtn++;
            } else if(set1.size() > set2.size()) {
                break;
            }
        }
        return rtn;
    }
}