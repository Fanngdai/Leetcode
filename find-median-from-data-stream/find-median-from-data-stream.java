class MedianFinder {
    // min heap
    PriorityQueue<Integer> left = null;
    // max heap
    PriorityQueue<Integer> right = null;
        
    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    /*
     * Always make sure there is same amt in both heap.
     * If anything, left always has 1 more max than the right
     */
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
 
        if(left.size()<right.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        return (left.size() > right.size()) ? left.peek() : (left.peek()+right.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */