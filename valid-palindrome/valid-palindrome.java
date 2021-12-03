class Solution {
    private boolean isPalindromeRec(String s, int left, int right) {
        if(left >= right){
            return true;
        } else if(s.charAt(left) != s.charAt(right)) {
            return false;
        } else {
            return isPalindromeRec(s, left+1, right-1);
        }
    }
    
    
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]","");
        return isPalindromeRec(s.toLowerCase(),0,s.length()-1);
    }
}