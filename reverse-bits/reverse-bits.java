public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rtn = 0;

        for(int i=0; i<32; i++) {
            rtn <<= 1;
            if((n&1)==1) {
                rtn += 1;
            }
            n >>= 1;
        }
        
        return rtn;
    }
}

/*
 * Loop through 32 times, bc 32 bits
 * add in from the right, remove from n from the right as well.
 * if n is 1 from the most right, then rtn would also be 1 at this time.
 */