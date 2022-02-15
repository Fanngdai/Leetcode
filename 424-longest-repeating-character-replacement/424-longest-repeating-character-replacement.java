class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, rtn = 0, max;
        int[] cnt = new int[26];
        
        for(int right = 0; right < s.length(); right++) {
            cnt[s.charAt(right)-'A']++;
            
            while(right-left-findMax(cnt)+1 > k) {
                cnt[s.charAt(left++)-'A']--;
            }
            
            rtn = Math.max(rtn, right-left+1);
        }
        
        return rtn;
    }
    
    private int findMax(int[] cnt) {
        int max = 0;
        for(int i=0; i<26; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }
}

/*
Logic
    Sliding windows, check if the window is valid, if it is, then Math.max
    Otherwise, shrink the left until the window is valid.

"ABAB"
2
"AABABBA"
1
"AAAAAAABAAAAAAA"
1
"AAAAAAAAAAAAABBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAA"
0
"ABBB"
2
*/