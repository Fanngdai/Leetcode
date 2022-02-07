class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        HashMap<String, Integer> memo = new HashMap<>();
        memo.put(text1.length() + "," + text2.length(), 0);
        return longestCommonSubsequenceHelper(text1, text2, 0, 0, memo);
    }
    
    private int longestCommonSubsequenceHelper(String text1, String text2, int index1, int index2,
                                               HashMap<String, Integer> memo) {
        String key = index1+","+index2;
        
        if(memo.containsKey(key) || index1 == text1.length() || index2 == text2.length()) {
            return memo.getOrDefault(key, 0);
        } else if(text1.charAt(index1) == text2.charAt(index2)) {
            return longestCommonSubsequenceHelper(text1, text2, index1+1, index2+1, memo) + 1;
        } else {
            int temp = Math.max(longestCommonSubsequenceHelper(text1, text2, index1, index2+1, memo),
                longestCommonSubsequenceHelper(text1, text2, index1+1, index2, memo));
            memo.put(key, temp);
            return temp;
        }
    }
}