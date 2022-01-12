class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        List<int[]> rtn = new ArrayList<>();

        int start = intervals[0][0], end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            
            // merge, they overlap somewhere
            if(currStart<=end) {
                // make if they overlap, or if second is within.
                if(end < currEnd) {
                    end = currEnd;
                }
            } else {
                rtn.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }
        rtn.add(new int[]{start, end});
        
        return rtn.toArray(new int[rtn.size()][2]);
    }
}

/*
 * Sort array by the first value, if first values are the same, sort by second value.
 * either merge or add to lst.
 */

// [[1,4],[2,3]]