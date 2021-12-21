class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int pointer = 0, max = prices[1] - prices[0];
        
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < prices[pointer]) {
                pointer = i;
            }
            if(prices[i] - prices[pointer] > max) {
                max = prices[i] - prices[pointer];
            }
        }
        return max < 0 ? 0 : max;
    }
}