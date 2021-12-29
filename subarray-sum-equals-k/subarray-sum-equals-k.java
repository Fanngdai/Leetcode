class Solution {
    public int subarraySum(int[] nums, int k) {
        // key = sum, val = total sum prior
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0, rtn = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            if(k == sum) {
                rtn++;
            }
            if(hash.containsKey(sum-k)) {
                rtn += hash.get(sum-k);
            }
            hash.put(sum, hash.containsKey(sum) ? hash.get(sum)+1 : 1);
        }
        return rtn;
    }
}

/*
 * Return how many continous subarrays that equal this value
 * I add the value and put it in a hashmap.
 * The (current sum - previous sum) is in the set, then there is a continous array somewhere.
 */

// [1,1,1]
// 2
// [1,2,3]
// 3
// [6,2,2,4,5]
// 13
// [5]
// 5
// [-1,-1,1]
// 0
// [1,-1,0]
// 0
// [0,0]
// 0
// [0,0,0,0,0,0,0,0,0,0]
// 0