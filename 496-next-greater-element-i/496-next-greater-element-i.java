class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1Len = nums1.length, n2Len = nums2.length;
        HashMap<Integer, Integer> greater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(Integer n: nums2) {
            while(!stack.isEmpty() && stack.peek() < n) {
                greater.put(stack.pop(), n);
            }
            stack.push(n);
        }
        
        for(int i=0; i<n1Len; i++) {
            nums1[i] = greater.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
}