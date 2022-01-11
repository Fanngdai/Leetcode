class Solution {
    public int minAddToMakeValid(String s) {
        int rtn = 0, leftParam = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                leftParam++;
            } else {
                if(leftParam == 0) {
                    rtn++;
                } else {
                    leftParam--;
                }
            }
        }
        
        return rtn + leftParam;
    }
}