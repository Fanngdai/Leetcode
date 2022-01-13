class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        
        PriorityQueue<Integer> minHeap = makeMinHeap(hand);
        
        // (O(n))
        while(!minHeap.isEmpty()) {
            int minVal = minHeap.remove();
            // O(groupSize)
            for(int i=1; i<groupSize; i++) {
                // O(logn)
                if(!minHeap.remove(minVal+i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // O(nlogn)
    private PriorityQueue<Integer> makeMinHeap(int[] hand) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: hand) {
            minHeap.add(i);
        }
        return minHeap;
    } 
}