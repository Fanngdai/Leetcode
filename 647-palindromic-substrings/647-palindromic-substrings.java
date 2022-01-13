class Solution {
    public int countSubstrings(String s) {
        int sLen = s.length(), rtn = s.length();

        for(int i=1; i<sLen; i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                rtn += countSubstringsHelper(s, i-2, i+1) + 1;
            }
            rtn += countSubstringsHelper(s, i-1, i+1);
        }
        
        return rtn;
    }
    
    private int countSubstringsHelper(String s, int left, int right) {
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}

/*
"aaaaa"
*/