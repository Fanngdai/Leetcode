class Solution {
    public int numOfWays(int n) {
        long same = 6, diff = 6, sameTemp, diffTemp;
        int mod = (int)Math.pow(10, 9) + 7;
        
        for(int i=0; i<n-1; i++) {
            sameTemp = 3 * same + 2 * diff;
            diffTemp = 2 * same + 2 * diff;
            same = sameTemp % mod;
            diff = diffTemp % mod;
        }
        
        return (int)(same + diff) % mod;
    }
}