class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int indexOfPeak = 0;
        
        for(int i=0; i<arr.length; i++) {
            int currHeight = arr[i];
            if(currHeight > arr[indexOfPeak]) {
                indexOfPeak = i;
            }
        }
        
        return indexOfPeak;
    }
}