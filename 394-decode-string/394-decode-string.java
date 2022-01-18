class Solution {
    public String decodeString(String s) {
        int sLen = s.length();
        String rtn = "";
        
        for(int i=0; i<sLen; i++) {
            char c = s.charAt(i);
            
            if(c == ']') {
                int rtnLen = rtn.length() - 1;
                String letters = "";
                c = rtn.charAt(rtnLen);

                // get all the letters
                while(Character.isLetter(c)) {
                    letters = c + letters;
                    c = rtn.charAt(--rtnLen);
                }
                
                if(rtn.charAt(rtnLen) == '[') {
                    rtnLen--;
                }
                
                int repeat = rtnLen;
                while(rtnLen > 0 && Character.isDigit(rtn.charAt(rtnLen-1))) {
                    rtnLen--;
                }
                
                repeat = Integer.parseInt(rtn.substring(rtnLen,repeat+1));

                String concat = "";
                for(int j=0; j<repeat; j++) {
                    concat += letters;
                }
                
                rtn = rtn.substring(0, rtnLen) + concat;
            } else if(c == '[' || Character.isDigit(c) || Character.isLetter(c)) {
                rtn += c;
            }
        }
        
        return rtn;
    }
    
}

/*
"2[abc]300[cd]ef"
*/