class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int pLen = piles.length, min = 1, max = 0;
        
        for(int i: piles) {
            max = Math.max(max, i);
        }
        
        if(pLen == h) {
            return max;
        }
        
        while(min < max) {
            int mid = min + (max-min) / 2;
            int hoursReqForMid = calcHoursNeeded(piles, mid, h);
            
            // if hoursReq is more, that means the value is too small
            if(hoursReqForMid > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        
        return max;
    }
    
    private int calcHoursNeeded(int[] piles, int val, int hour) {
        int rtn = 0;
        for(int i=0; i<piles.length; i++) {
            rtn += Math.ceil((double)piles[i]/val);
            if(rtn > hour) {
                return rtn;
            }
        }
        return rtn;
    }
}

/*
min is one at a time... max is the largest value in the array

[312884470]
312884469
[332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184]
823855818
[1000000000,1000000000]
3
*/