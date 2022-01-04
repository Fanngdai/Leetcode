class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        
        StringBuilder rtn = new StringBuilder();
        boolean isNeg = false;
        
        if(num<0) {
            isNeg = true;
            num *= -1;
        }
        
        while(num != 0) {
            rtn.append(num%7);
            num /= 7;
        }
        
        if(isNeg) {
            rtn.append("-");
        }
        
        return rtn.reverse().toString();
    }
}