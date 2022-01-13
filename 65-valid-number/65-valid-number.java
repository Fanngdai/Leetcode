class Solution {
    public boolean isNumber(String s) {
        int i = 0, sLen = s.length();
        boolean decimalFound = false, eFound = false, numFound = false;
        
        if(s.charAt(i)=='-' || s.charAt(i)=='+') {
            i++;
        }
        
        for(; i<sLen; i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                numFound = true;
            } else if(c == '.') {
                if(decimalFound || eFound) return false;
                decimalFound = true;
            } else if(c == 'E' || c == 'e') {
                // if e was already found, or there is no num before e, or e is that last char
                if(eFound || !numFound || i == sLen-1) return false;
                eFound = true;
                numFound = false;
                
                // skip the sign if found.
                if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-') {
                    i++;
                }
            } else {
                return false;
            }
        }

        return numFound;
    }
}

/*
 * Regex -> [-+]?/d+.?/d*([eE]?[-+]?num+)
 * true
"+0.e-2"


"2"
"0089"
"-0.1"
"+3.14"
"4."
"-.9"
"2e10"
"-90E3"
"3e+7"
"+6e-1"
"53.5e93"
"-123.456e789"
"abc"
"1a"
"1e"
"e3"
"99e2.5"
"--6"
"-+3"
"95a54e53"
*/