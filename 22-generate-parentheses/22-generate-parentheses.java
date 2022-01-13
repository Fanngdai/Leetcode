class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rtn = new ArrayList<>();
        generateParenthesisHelper(n, n, "", rtn);
        return rtn;
    }
    
    private void generateParenthesisHelper(int open, int close, String s, List<String> rtn) {
        if(open == 0) {
            for(int i=0; i<close; i++) {
                s += ')';
            }
            rtn.add(s);
            return;
        } else if(close < open) {
            return;
        }
        
        generateParenthesisHelper(open-1, close, s+'(', rtn);
        generateParenthesisHelper(open, close-1, s+')', rtn);
    }
}