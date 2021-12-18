class Solution {
    public int myAtoi(String s) {
        s = s.strip();
        double result = 0;
        boolean neg = false;
        
        if(s.isEmpty()) {
            return 0;
        }
        
        switch (s.charAt(0)) {
            case '-':
                neg = true;
            case '+':
                result = findInt(s, 1);
                break;
            default:
                result = findInt(s, 0);
        }
        
        if(neg) {
            result *= -1;
        }
        if(result>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(result<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
    
    private double findInt(String s, int start) {
        double num = 0;
        for(int i=start; i<s.length(); i++) {
            char letter = s.charAt(i);
            if(letter >= '0' && letter <= '9') {
                num = num * 10 + (letter-'0');
            } else if(letter<'0' || letter>'9' || letter == '-' || letter == '+') {
                break;
            }
        }
        return num;
    }
}


// "42"
// "   -42"
// "4193 with words"
// "   0"
// "   -0"
// "words and 987"
// "-91283472332"
// "91283472332"
// "+1"
// "+-12"
// "00000-42a1234"