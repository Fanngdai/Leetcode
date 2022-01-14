class Solution {        
    public List<String> letterCombinations(String digits) {
        List<String> rtn = new ArrayList<>();
        if(digits.length() == 0) {
            return rtn;
        }
        
        Map<Character, String> digToLet = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        letterCombinationsHelper(rtn, digits, digToLet, new StringBuilder(), 0);
        
        return rtn;
    }
    
    private void letterCombinationsHelper(List<String> rtn, String digits,
          Map<Character, String> digToLet, StringBuilder sb, int index) {
        if(index == digits.length()) {
            rtn.add(sb.toString());
            return;
        }
        
        // Get all the letters associated with the number
        String let = digToLet.get(digits.charAt(index));
        for(int i=0; i<let.length(); i++) {
            letterCombinationsHelper(rtn, digits, digToLet, 
                 new StringBuilder(sb).append(let.charAt(i)), index+1);
        }
        
    }
}