class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> rtn = new ArrayList<>();
        letterCasePermutationHelper(rtn, s, "");
        return rtn;
    }
    
    private void letterCasePermutationHelper(List<String> lst, String str, String strRtn) {
        int strLen = str.length();
        
        if(strLen == strRtn.length()) {
            lst.add(strRtn);
            return;
        }
        
        for(int i=strRtn.length(); i<strLen; i++) {
            char c = str.charAt(i);
            if(Character.isLetter(c)) {
                letterCasePermutationHelper(lst, str, strRtn + (char)(c^32));
            }
            strRtn += c;
            if(strRtn.length() == strLen) {
                lst.add(strRtn);
            }
        }
    }
    
}