class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] left = new int[k+1], right = new int[k+1];
        left[0] = 0;
        right[0] = 0;
        
        for(int i=1; i<=k; i++) {
            left[i] = left[i-1] + cardPoints[i-1];
            right[i] = right[i-1] + cardPoints[cardPoints.length-i];
        }
        
        int rtn = 0;
        for(int i=0; i<=k; i++) {
            rtn = Math.max(rtn, left[i] + right[k-i]);
        }
        
        return rtn;
    }
    
    public int maxScoreRecursion(int[] cardPoints, int k) {
        return maxScoreRecursionHelper(cardPoints, k, 0, cardPoints.length-1);
    }
    
    public int maxScoreRecursionHelper(int[] cardPoints, int k, int left, int right) {
        if(k==0) return 0;
        
        return Math.max(maxScoreRecursionHelper(cardPoints, k-1, left+1, right) + cardPoints[left],
                        maxScoreRecursionHelper(cardPoints, k-1, left, right-1) + cardPoints[right]);
    }
}

/*
[53,14,91,35,51,9,80,27,6,15,77,86,34,62,55,45,91,45,23,75,66,42,62,13,34,18,89,67,93,83,100,14,92,73,48,2,47,93,99,100,88,84,48]
43
*/