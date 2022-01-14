class Solution {
    public int[] countBits(int n) {
        int[] rtn = new int[n+1];
        rtn[0] = 0;
        
        int pow = 1, index = 1;
        
        for(int i=1; i<=n; i++) {
            if(i==pow) {
                rtn[i] = 1;
                pow <<= 1;
                index = 1;
            } else {
                rtn[i] = rtn[index++] + 1;
            }
        }
        return rtn;
    }
}

/*
 100000
 */