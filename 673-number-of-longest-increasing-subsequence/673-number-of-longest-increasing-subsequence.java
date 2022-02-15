class Solution {
    public int findNumberOfLIS(int[] nums) {
        int nLen = nums.length, maxLen = 0, rtn = 0;
        int[] lis = new int[nLen];
        int[] cnt = new int[nLen];
        
        for(int i=0; i<nLen; i++) {
            lis[i] = 1;
            cnt[i] = 1;
            
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(lis[j]+1 > lis[i]) {
                        lis[i] = lis[j]+1;
                        cnt[i] = cnt[j];
                    } else if(lis[j]+1 == lis[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            
            if(lis[i] > maxLen) {
                maxLen = lis[i];
                rtn = cnt[i];
            } else if(lis[i] == maxLen) {
                rtn += cnt[i];
            }
        }
        
        return rtn;
    }
}

/*
Logic
    lis is an array that stores the lis from length 0 to the current index

[1,3,5,4,7]
[2,2,2,2,2]
[3,1,2]             -> 1
[2,1]               -> 1
[1,2,4,3,5,4,7,2]   -> 3
*/