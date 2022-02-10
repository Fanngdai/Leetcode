class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> rtn = new ArrayList<>();
        partitionHelper(str, 0, rtn, new ArrayList<>());
        return rtn;
    }
    
    private void partitionHelper(String str, int start, List<List<String>> rtn, List<String> lst) {
        int strLen = str.length();
        
        if(start == strLen) {
            rtn.add(new ArrayList<>(lst));
            return;
        }
        
        for(int i=start; i<strLen; i++) {
            if(isPalindrome(str, start, i)) {
                lst.add(str.substring(start, i+1));
                partitionHelper(str, i+1, rtn, lst);
                lst.remove(lst.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int index1, int index2) {
        while(index1 < index2) {
            if(str.charAt(index1) != str.charAt(index2))
                return false;
            index1++;
            index2--;
        }
        return true;
    }
}