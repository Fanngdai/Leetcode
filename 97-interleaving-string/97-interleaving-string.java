class Solution {
    // s1 put in row, s2 put in col
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();
        
        // length do not match
        if(s1Len+s2Len!=s3Len) {
            return false;
        }
        
        boolean[][] dp = new boolean[s1Len+1][s2Len+1];
        for (boolean[] row: dp)
            Arrays.fill(row, false);
        dp[0][0] = true; 
        
        // fill in first row, take value from left
        for(int c=1; c<=s2Len; c++) {
            System.out.println("###" + s2.charAt(c-1) + "\t" + s3.charAt(c-1));
            if(s2.charAt(c-1) == s3.charAt(c-1)) {
                dp[0][c] = dp[0][c-1];
            }
        }
        // fill in first col, take value from top
        for(int r=1; r<=s1Len; r++) {
            System.out.println(s1.charAt(r-1) + "\t" + s3.charAt(r-1));
            if(s1.charAt(r-1) == s3.charAt(r-1)) {
                dp[r][0] = dp[r-1][0];
            }
        }
        
        for(int r=1; r<=s1Len; r++) {
            for(int c=1; c<=s2Len; c++) {
                int position = r + c - 1;
                if(s1.charAt(r-1) == s3.charAt(position)) {
                    // look top
                    dp[r][c] = dp[r-1][c];
                }
                if(s2.charAt(c-1) == s3.charAt(position) && !dp[r][c]) {
                    // look left
                    dp[r][c] = dp[r][c-1];
                }
            }
        }
        
        // print(dp);
        return dp[s1Len][s2Len];
    }
    
    // testing purposes
    private void print(boolean[][] dp) {
        for(int r=0; r<dp.length; r++) {
            for(int c=0; c<dp[0].length; c++) {
                System.out.print(dp[r][c] + "\t");
            }
            System.out.println();
        }
    }
}

// "a"
// ""
// "a"