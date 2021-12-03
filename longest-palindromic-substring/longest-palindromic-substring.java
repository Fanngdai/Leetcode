class Solution {
    
    /*
     * Recursive
     * Makes sure the indexes are correct. Also make sure the chars at left and right
     * are equal. If index are no go, or chars are not equal, return from left and right,
     * not including the new indexes.
     */
    public String checkPalindrome(String s, int index, int left, int right) {
        if(left<0 || right>s.length()-1 || s.charAt(left) != s.charAt(right)) {
            return s.substring(left+1,right);
        } else {
            return checkPalindrome(s, index, left-1, right+1);
        }
    }
    
    /*
     * Loops through the entire string and calls the check palindrome method at every index.
     * Given the longest palindrome that can be formed at index, check if current hold val
     * is shorter, in such case, replace with the new given palindrome
     *
     * Consider odd and even palindromes.
     */
    public String longestPalindrome(String s) {
        String max = s.charAt(0) + "";
        // loop from second index to last
        for(int charIndex = 1; charIndex < s.length(); charIndex++) {
            // if prev or after is same char
            if(s.charAt(charIndex-1) == s.charAt(charIndex)) {
                max = longerString(max, checkPalindrome(s,charIndex,charIndex-2,charIndex+1));
            }
            // if (charIndex != s.length()-1 && s.charAt(charIndex+1) == s.charAt(charIndex)) {
            //     max = longerString(max, checkPalindrome(s,charIndex,charIndex-1,charIndex+2));
            // }
            max = longerString(max, checkPalindrome(s,charIndex,charIndex-1,charIndex+1));
        }
        return max;
    }
    
    /*
     * Returns the longer of the 2 strings
     */
    public String longerString(String s1, String s2) {
        return s1.length()>=s2.length() ? s1 : s2;
    }
    
}