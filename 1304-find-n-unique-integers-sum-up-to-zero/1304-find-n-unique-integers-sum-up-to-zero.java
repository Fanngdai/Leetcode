class Solution {
    public int[] sumZero(int n) {
        int counter = n/2*-1;
        int[] rtn = new int[n];
        
        for(int i=0; i<n; i++) {
            rtn[i] = counter++;
        }
        
        if(n%2==0) {
            rtn[n/2] = counter;
        }
        
        return rtn;
    }
}

/*
3 -> [-1,0,1]
4 -> [-2,-1,1,2]
5 -> [-2,-1,0,1,2]
*/