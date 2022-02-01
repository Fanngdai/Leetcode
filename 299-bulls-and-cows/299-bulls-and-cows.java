class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] sInt = new int[10];
        int[] gInt = new int[10];
        
        Arrays.fill(sInt, 0);
        Arrays.fill(gInt, 0);
        
        for(int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) {
                bull++;
            } else {
                sInt[s-'0']++;
                gInt[g-'0']++;
            }
        }
        
        for(int i=0; i<10; i++) {
            cow += Math.min(sInt[i], gInt[i]);
        }
        
        return bull + "A" + cow + "B";
    }
}

/*
"0100"
"0110"
"3A0B"

"0100"
"2112"
"1A0B"

"1234566"
"6786907"
"0A2B"
*/