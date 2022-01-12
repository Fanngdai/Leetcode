class Solution {
    public boolean isHappy(int n) {
        int[] square = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        Map<Integer, Integer> hash = new HashMap<>();
        
        while(n>9) {
            n = isHappyHelper(n, square, hash);
        }
        return n == 1 || n == 7;
    }
    
    private int isHappyHelper(int n, int[] square, Map<Integer, Integer> hash) {
        if(hash.containsKey(n)) return hash.get(n);
        
        int sum = 0;
        while(n>0) {
            sum += square[n%10];
            n /= 10;
        }
        hash.put(n, sum);
        return sum;
    }
}