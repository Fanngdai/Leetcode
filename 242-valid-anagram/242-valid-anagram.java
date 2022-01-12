class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        
        if(sLen != tLen) {
            return false;
        }
        
        int[] sArr = new int[26], tArr = new int[26];
        Arrays.fill(sArr, 0);
        Arrays.fill(tArr, 0);
        
        for(int i=0; i<sLen; i++) {
            sArr[s.charAt(i)-'a']++;
            tArr[t.charAt(i)-'a']++;
        }
        
        return Arrays.equals(sArr, tArr);
    }
}