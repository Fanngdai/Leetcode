class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int pLen = points.length;
        if(pLen == k) return points;
        
        // min heap where val determines how to sort
        PriorityQueue<Distance> heap = new PriorityQueue<>((a,b) -> a.val-b.val);
        
        for(int i=0; i<pLen; i++) {
            heap.add(new Distance(points[i]));
        }
        
        int[][] rtn = new int[k][2];
        for(int i=0; i<k; i++) {
            rtn[i] = heap.poll().points;
        }
        
        return rtn;
    }
}

class Distance {
    // value before we sqrt it, we don't need the sqrt
    int val;
    // points which we have to return 
    int[] points;
    
    public Distance(int[] points) {
        this.points = points;
        val = (int)Math.pow(points[0],2) + (int)Math.pow(points[1],2);
    }
}