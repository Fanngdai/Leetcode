class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int low = 0, high = 0, max = 0;
        
        while(low < prices.length && high < prices.length) {
            // look for low val
            while (low < prices.length-1 && prices[low+1] <= prices[low]) {
                low++;
            }
            
            // look for high val
            high = low+1;
            while(high < prices.length - 1 && prices[high+1] > prices[high]) {
                high++;
            }
            
            // if valid, then take difference
            if(low < prices.length && high < prices.length)
                max += prices[high] - prices[low];
            
            // now set the low to highs next
            low = high + 1;
        }
        return max;
    }
}