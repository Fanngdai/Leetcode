class Solution {
    public String addBinary(String a, String b) {
        int aLength = a.length()-1, bLength = b.length()-1;
        String rtn = "";
        char aChar, bChar, carryOver = '0';
        
        while(carryOver == '1' || aLength >= 0 || bLength >= 0) {
            aChar = aLength < 0 ? '0' : a.charAt(aLength--);
            bChar = bLength < 0 ? '0' : b.charAt(bLength--);
            
            if(aChar == '0' && bChar == '0') {
                if(carryOver == '1') {
                    rtn = '1' + rtn;
                    carryOver = '0';
                } else {
                    rtn = '0' + rtn;
                }
            } else if(aChar == '1' && bChar == '1') {
                if(carryOver == '1') {
                    rtn = '1' + rtn;
                } else {
                    rtn = '0' + rtn;
                }
                carryOver = '1';
            } else {
                if(carryOver == '1') {
                    rtn = '0' + rtn;
                    carryOver = '1';
                } else {
                    rtn = '1' + rtn;
                }
            }
        }
        return rtn;
    }
}