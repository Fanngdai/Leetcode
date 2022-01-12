class Solution {
    public boolean isHappy(int n) {
        // int[] square = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        // Map<Integer, Integer> hash = new HashMap<>();
        
        
        while(n>9) {
            n = isHappyHelper(n);
        }
        return n == 1 || n == 7;
    }
    
    private int isHappyHelper(int n) {
        
        int sum = 0;
        while(n>0) {
            // sum += square[n%10];
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
}