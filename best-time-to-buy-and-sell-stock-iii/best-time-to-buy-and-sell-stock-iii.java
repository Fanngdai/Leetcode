class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = prices[0], firstProfit = 0, secondBuy = Integer.MAX_VALUE, secondProfit = 0;
        for(int day=1; day<prices.length; day++) {
            int p = prices[day];
            firstBuy = Math.min(firstBuy, p);
            firstProfit = Math.max(firstProfit, p-firstBuy);
            secondBuy = Math.min(secondBuy, p-firstProfit);
            secondProfit = Math.max(secondProfit, p-secondBuy);
        }
        return secondProfit;
    }
}

/*
 * Formula here is find the smallest value from the left -> this is the firstBuy
 * Then you find the max you can sell -> profit
 * that sum minus the min you can after firstProfit.
 * Then add the last profit to that.
 * [1,2,4,2,5,7,2,4,9,0]
 * 1,2,4 -> 3
 * 2,5,7 -> 5
 * 2,4,9 -> 7
 * maxProfit - secondBuyMin + secondProfit
 */

// [14,9,10,12,4,8,1,16]
// [3,3,5,0,0,3,1,4]
// [1,2,3,4,5]
// [1,2,3,4,5,4,3,2,1]
// [7,6,4,3,1]
// [6,1,3,2,4,7]
// [1,2,4,2,5,7,2,4,9,0]
// [1,2,4,2,5,7,2]
