class Solution {
    public int firstUniqChar(String s) {
        int sLen = s.length();
        Set<Character> set = new HashSet<>();
        
        for(int i=0; i<sLen; i++) {
            char c = s.charAt(i);
            if(!set.contains(c) && s.substring(i+1,sLen).indexOf(c) == -1) {
                return i;
            }
            set.add(c);
        }    
        return -1;
    }
}