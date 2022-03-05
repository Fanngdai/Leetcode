class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // maxheap to store by the numberofunitsperbox
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(int i=0; i<boxTypes.length; i++) {
            heap.add(boxTypes[i]);
        }
        
        int rtn = 0;
        while(truckSize > 0 && !heap.isEmpty()) {
            int min = Math.min(truckSize, heap.peek()[0]);
            rtn += min * heap.poll()[1];
            truckSize -= min;
        }
        
        return rtn;
    }
}