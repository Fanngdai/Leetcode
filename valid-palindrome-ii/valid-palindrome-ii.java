class Solution {
    private boolean checkPalindrome(String s, int left, int right, boolean deleted) {
        if(left>=right) {
            return true;
        } else if(s.charAt(left) != s.charAt(right) && deleted) {
            return false;
        } else if(s.charAt(left) != s.charAt(right)) {
            return checkPalindrome(s, left+1, right, true) ||
                checkPalindrome(s, left, right-1, true);
        } else {
            // equal
            return checkPalindrome(s, left+1, right-1, deleted);
        }
    }
    
    public boolean validPalindrome(String s) {
        return checkPalindrome(s, 0, s.length()-1, false);
    }
}