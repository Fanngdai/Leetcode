class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // key = mod, val = index
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if(hash.containsKey(mod) && i-hash.get(mod) > 1 || mod == 0 && i >= 1) {
                return true;
            } else if(!hash.containsKey(mod)) {
                hash.put(mod, i);
            }
        }
        
        return false;
    }
}

/*
 * val1 % k = n
 * val2 % k = n
 * then (val1 - val2) % k = 0
 */

// [23,2,4,6,7]
// 6
// [23,2,6,4,7]
// 6
// [23,2,6,4,7]
// 13
// [1,0]
// 2
// [23,2,4,6,6]
// 7
// [5,0,0,0]
// 3
// [0]
// 1
// [2,4,3]
// 6