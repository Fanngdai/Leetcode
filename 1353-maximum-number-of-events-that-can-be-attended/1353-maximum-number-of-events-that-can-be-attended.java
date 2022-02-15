class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> a[0]-b[0] != 0 ? a[0]-b[0] : a[1]-b[1]);
        
        for(int i=0; i<events.length; i++) {
            queue.add(events[i]);
        }
        
        int day = -1, rtn = 0;
        
        while(!queue.isEmpty()) {
            // if smaller or if intervals not good, delete
            while(!queue.isEmpty() && day > queue.peek()[1]) {
                queue.poll();
            }
            if(queue.isEmpty()) {
                break;
            }
            
            day = queue.poll()[0];
            rtn++;
            
            int tempDay = day;
            while(!queue.isEmpty() && queue.peek()[0] == day) {
                int[] temp = queue.poll();
                if(tempDay+1 <= temp[1]) {
                    temp[0] = ++tempDay;
                    queue.add(temp);
                }
            }
        }
        
        return rtn;
    }
}


/*
Logic
    Sort array by ending time in non-decreasing order
        If they have the same ending time, sort by starting time in non-decreasing order
    variable day keeps track of which day we are on, taking the earliest day we can
        Which is either day + 1 or the start day

[[1,2],[2,3],[3,4]]
[[1,2],[2,3],[3,4],[1,2]]
[[1,4],[4,4],[2,2],[3,4],[1,1]]
[[1,100000]]
[[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
[[1,5],[1,5],[1,5],[2,3],[2,3]]
*/