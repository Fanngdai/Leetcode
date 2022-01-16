class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        
        int hayStackLen = haystack.length(), needleLen = needle.length();
        for(int i=0; i<haystack.length()-needle.length()+1; i++) {
            if(haystack.substring(i,i+needleLen).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}

/*
If value not found, return -1
*/