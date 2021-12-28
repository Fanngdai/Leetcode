class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] manyCoins = new int[amount+1];
        manyCoins[0] = 0;
        
        // Go through each amount
        for(int amt=1; amt<=amount; amt++) {
            manyCoins[amt] = Integer.MAX_VALUE;
            // Go through each coin
            for(int c=0; c<coins.length; c++) {
                // If coin is amt, then just set equal to 1 and go to next value
                if(coins[c] == amt) {
                    manyCoins[amt] = 1;
                    continue;
                } else if(coins[c] < amt) {
                    // Get the remaining min coins
                    int remain = manyCoins[amt-coins[c]];
                    if(remain != Integer.MAX_VALUE && remain+1 < manyCoins[amt]) {
                        manyCoins[amt] = remain+1;
                    }
                }
            }
        }

        return manyCoins[amount] == Integer.MAX_VALUE ? -1 : manyCoins[amount];
    }
}

// [1,2,5]
// 11
// [2]
// 3
// [1]
// 0
// [1,5,10,11]
// 50
// [9,6,5,1]
// 11