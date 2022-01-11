class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p);
    }
    
    private boolean isMatchHelper(String s, String p) {
        // System.out.println("#" + s + "\t" + p);
        if(s.length()==0 && p.length()==0) {
            return true;
        } else if(s.length()==0) {
            int counter = 1;
            while(p.length() > counter && p.charAt(counter) == '*') {
                counter+=2;
            }
            return counter > p.length();
        } else if(p.length()==0) {
            return false;
        }
            
        if(p.length() > 1 && p.charAt(1) == '*') {
            char charToRemove = p.charAt(0);
            p = p.substring(2,p.length());
            
            if(charToRemove == '.') {
                int len = s.length();
                for(int i=0; i<=s.length(); i++) {
                    if(isMatchHelper(s.substring(i,len), p))
                        return true;
                }
                return false;
            } else {
                int len = s.length();
                int i = 0;
                // remove none
                if(isMatchHelper(s.substring(i,len), p)) {
                    return true;
                }
                // remove one char at a time that are the same and check
                while(i < s.length() && s.charAt(i) == charToRemove) {
                    if(isMatchHelper(s.substring(i+1,len), p)) {
                        return true;
                    }
                    i++;
                }
            }
            return false;
        } else if(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
            return isMatchHelper(s.substring(1, s.length()), p.substring(1, p.length()));
        }
        return false;
    }
}

/*
 what if **?
 ..
 .*.*
 .*...
*/

// "aaaaabbbbb"
// ".*.*"
// "aa"
// "a"
// "aa"
// "a*"
// "ab"
// ".*"
// "aaaaaaa"
// "a*aaaa"
// "aaaaaaa"
// "aa*aaaaa"
// "ab"
// ".*c"
// "aaa"
// "ab*a*c*a"
// "a"
// "ab*"
// "aaaaaaaaaaaaab"
// "a*a*a*a*a*a*a*a*a*a*a*a*b"
// "bbbaccbbbaababbac"
// ".b*b*.*...*.*c*."
// "aaaaaaaaaaaaab"
// "a*a*a*a*a*a*a*a*a*a*c"