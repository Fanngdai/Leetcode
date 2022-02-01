class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int rowDiff = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]), 
        colDiff = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);
        
        for(int i=1; i<horizontalCuts.length; i++) {
            rowDiff = Math.max(rowDiff, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        
        for(int i=1; i<verticalCuts.length; i++) {
            colDiff = Math.max(colDiff, verticalCuts[i]-verticalCuts[i-1]);
        }
        
        return (int)((long)rowDiff * colDiff % 1000000007);
    }
}

/*
Get the max height and width, then multiple it

1000000000
1000000000
[2]
[2]
*/