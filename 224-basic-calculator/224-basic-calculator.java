class Solution {
    public int calculate(String s) {
        int sLen = s.length();
        Stack<Integer> operator = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        
        for(int i=0; i<sLen; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            } else if(c==')') {
                int val = calculateSum(s, operator, nums);
                makeNeg(s, operator, nums, val);
            } else if(Character.isDigit(c)) {
                int val = (int)c - '0';
                while (i+1 < sLen && Character.isDigit(s.charAt(i+1))) {
                    c = s.charAt(++i);
                    val = val * 10 + ((int)c - '0');
                }
                makeNeg(s, operator, nums, val);
            } else {
                operator.push(i);
            }
            // System.out.println(Arrays.toString(operator.toArray()));
            // System.out.println(Arrays.toString(nums.toArray()) + "\n");
        }
        
        return calculateSum(s, operator, nums);
    }
    
    private int calculateSum(String s, Stack<Integer> operator, Stack<Integer> nums) {
        int sum = nums.pop();
        while(!operator.isEmpty() && (operator.peek()==-1 || s.charAt(operator.peek()) != '(')) {
            if(operator.peek() == -1 || s.charAt(operator.peek()) == '+') {
                operator.pop();
                sum += nums.pop();
            }
        }
        if(!operator.isEmpty() && s.charAt(operator.peek()) == '(') {
            operator.pop();
        }
        return sum;
    }
    
    // deals with minus, make that value a neg instead of minus
    private void makeNeg(String s, Stack<Integer> operator, Stack<Integer> nums, int val) {
        if(!operator.isEmpty() && s.charAt(operator.peek()) == '-') {
            val *= -1;
            int op = operator.pop();
            if(operator.isEmpty() && nums.size() > 0 || !operator.isEmpty() && op-1 != operator.peek()) {
                operator.push(-1);
            }
        }
        nums.push(val);
    }
}

/*
 * [] Cases to consider, negative numbers
 * [check] mulitple digit nums -> 123 is a digit
 *
"-2+ 1"
"1-(-2)"
"2-(5-6)"
"- (3 + (4 + 5))"
"- (3 - (- (4 + 5) ) )"
 */ 