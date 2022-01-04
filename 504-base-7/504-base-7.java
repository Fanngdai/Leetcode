class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        
        String rtn = "";
        boolean isNeg = false;
        
        if(num<0) {
            isNeg = true;
            num *= -1;
        }
        
        while(num != 0) {
            rtn = (num%7) + rtn;
            num /= 7;
        }
        
        if(isNeg) {
            rtn = "-" + rtn;
        }
        
        return rtn;
    }
}