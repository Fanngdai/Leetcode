class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int wLen = weights.length, min = 0, max = 0;
        for(int i=0; i<wLen; i++) {
            // find the largest value in the array
            min = Math.max(min, weights[i]);
            // the whole sum
            max += weights[i];
        }
        
        if(days == 1) return max;
        
        int rtn = max;
        while(min<max) {
            int mid = min+(max-min)/2;
            int daysRequired = binarySearch(weights, wLen, mid, days);
            
            if(daysRequired>days) {
                min = mid+1;
            } else {
                max = mid;
                rtn = mid;
            }
        }
        
        return rtn;
    }
    
    // calc the days required for this weight
    private int binarySearch(int[] weights, int wLen, int weight, int days) {
        int rtn = 1, sum = 0;
        for(int i=0; i<wLen; i++) {
            sum += weights[i];
            if(sum > weight) {
                sum = weights[i];
                rtn++;
            }
            // to optimize
            if(rtn > days) {
                return rtn;
            }
        }
        // the last sum is not added in
        return rtn;
    }
}

/*
Logic:
    The min weight we can have is the max value in this array
    The max weight is the whole size of the array
    
    The logic would be start from min and keep adding 1 to it until it is enough days
        The would be O(n) * O(max-min)
        
    What I did here is use binary search with the min and max
        Set the mid to the middle of min and max
        If the result of mid weight is larger, meaning more days, we need more weights
        otherwise, we are at a good weight, but want to figure out the optimal weight
            So go left and figure that out
        O(n) * O(logn)
        
[10,50,100,100,50,100,100,100]
5
*/