class Solution {
    public int maxProfit(int[] prices) {
        int pLen = prices.length;
        if(pLen < 2) return 0;
        
        int buy = -prices[0], sell = 0, cooldown = 0;
        
        for(int i=1; i<pLen; i++) {
            int preSell = sell, preBuy = buy;
            
            buy = Math.max(buy, cooldown-prices[i]);
            sell = Math.max(sell, prices[i]+preBuy);
            cooldown = Math.max(cooldown, preSell);
            
        }
        
        return Math.max(sell, cooldown);
    }
}

