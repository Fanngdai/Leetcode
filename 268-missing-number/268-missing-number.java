class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length, arraySum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += i;
            arraySum += nums[i];
        }
        return sum - arraySum;
    }
}

/*
 * You can sort it -> O(nlogn) time     O(1) space
 * Put it in a set -> O(n) time         O(n) space
 */