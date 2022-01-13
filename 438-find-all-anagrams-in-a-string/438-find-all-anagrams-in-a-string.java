class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length(), sLen = s.length(), index = 0;
        List<Integer> rtn = new ArrayList<>();
        
        if(pLen > sLen) {
            return rtn;
        }
        
        int[] pArr = makeStringArr(p, pLen);
        int[] sArr = makeStringArr(s, pLen);
        
        
        for(int i=0; i<sLen-pLen; i++) {
            if(Arrays.equals(pArr, sArr)) {
                rtn.add(i);
            }
            sArr[s.charAt(i)-'a']--;
            sArr[s.charAt(i+pLen)-'a']++;
        }
        
        if(Arrays.equals(pArr, sArr)) {
            rtn.add(sLen-pLen);
        }
        
        return rtn;
    }
    
    private int[] makeStringArr(String s, int len) {
        int[] rtn = new int[26];
        Arrays.fill(rtn, 0);
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            rtn[c-'a']++;
        }
        return rtn;
    }
}

/*
"aa"
"bb"

"aaaaaaaaaa"
"aaaaaaaaaaaaa"
*/