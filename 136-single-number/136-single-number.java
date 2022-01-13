class Solution {
    public int singleNumber(int[] nums) {
        int rtn = 0;
        for(int i: nums) {
            rtn = rtn ^ i;
        }
        return rtn;
    }
}