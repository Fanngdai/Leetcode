class Solution {
    public int calculate(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        
        int index = 0, sLen = str.length();
        
        while(index != sLen) {
            char c = str.charAt(index);
            
            if(c == ' ') {
                index++;
            } else if(Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while(++index != sLen && Character.isDigit(c = str.charAt(index))) {
                    sb.append(c);
                }
                
                int currInt = Integer.parseInt(sb.toString());
                
                if(!opStack.isEmpty()) {
                    if(opStack.peek() == '*') {
                        int val = integerStack.pop();
                        currInt *= val;
                        opStack.pop();
                    } else if(opStack.peek() == '/') {
                        int val = integerStack.pop();
                        currInt = val / currInt;
                        opStack.pop();
                    } else if(opStack.peek() == '-') {
                        currInt *= -1;
                        opStack.pop();
                    }
                }
                integerStack.push(currInt);
            } else {
                opStack.push(c);
                index++;
            }
        }
        

        int sum = 0;
        while(!integerStack.isEmpty()) {
            sum += integerStack.pop();
        }
        
        return sum;
    }
}

/*
"0-2147483647"
"1-1"
*/