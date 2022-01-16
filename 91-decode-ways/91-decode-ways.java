class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int sLen = s.length();
        
        int count1 = 1, count2 = 1, count;
        for(int i=1; i<sLen; i++) {
            count = 0;
            
            // if it is only 1 digit, it will have all the prev results
            if(s.charAt(i) != '0') {
                count = count2;
            }
            
            // if it is 2 digits which is legal, add all the values before the prev
            if(isTwoDigits(s,i-1)) {
                count += count1;
            }
            
            count1 = count2;
            count2 = count;
        }
        
        return count2;
    }
    
    // 10 <= val <= 26
    private boolean isTwoDigits(String s, int i) {
        return s.charAt(i) == '1'
            || (s.charAt(i) == '2' && s.charAt(i+1)>='0' && s.charAt(i+1)<'7');
    }
}

/*
"226"
"06"
"12"
"0226"          check leading 0, which should return 0
"2260"          check if 60, which should return 0
"10"
"2101"
"1123"
"2201"
"123123"
"12321"
*/