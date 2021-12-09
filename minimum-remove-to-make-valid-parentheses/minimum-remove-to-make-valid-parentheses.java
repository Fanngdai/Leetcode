class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        
        while(index != s.length()) {
            if(s.charAt(index) == '(') {
                stack.push(index);
            } else if(s.charAt(index) == ')') {
                if(stack.empty()) {
                    s = s.substring(0,index) + s.substring(index+1);
                    continue;
                } else {
                    stack.pop();
                }
            }
            index++;
        }
        
        System.out.println(s);
        while(!stack.empty()) {
            index = stack.pop();
            s = s.substring(0,index) + s.substring(index+1);
        }
        return s;
    }
}

