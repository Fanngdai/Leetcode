class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        return eraseOverlapIntervalsHelper(intervals[0], 1, intervals);
    }
    
    /*
     * @param prev      previous int array to compare
     * @param index     index for intervals which we are comparing
     * @param intervals sorted arrays to compare
     *
     * @ return the value to remove overlap.
     */
    public int eraseOverlapIntervalsHelper(int[] prev, int index ,int[][] intervals) {
        if(index >= intervals.length)
            return 0;
        
        // overlap
        if(prev[1] > intervals[index][0]) {
            if(prev[1] < intervals[index][1]) {
                return eraseOverlapIntervalsHelper(prev, index+1, intervals) + 1;
            } else {
                return eraseOverlapIntervalsHelper(intervals[index], index+1, intervals) + 1;
            }
        } else {
            return eraseOverlapIntervalsHelper(intervals[index], index+1, intervals);
        }
    }
}