class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        return bellmanFord(times, n, k);
    }
    
    private int bellmanFord(int[][] times, int n, int k) {
        // to store the path from k to ...
        int[] vertex = new int[n];
        for(int i=0; i<n; i++) {
            vertex[i] = -1;
        }
        vertex[k-1] = 0;
        
        for(int i=0; i<n; i++) {
            for(int[] edge: times) {
                int from = edge[0] - 1;
                int to = edge[1] - 1;
                int weight = edge[2];
                if(vertex[from] != -1 && (vertex[from] + weight < vertex[to] || vertex[to] == -1)) {
                    // if from is set, and the new path is less than what is there
                    vertex[to] = vertex[from] + weight;
                }
            }
        }
        
        int max = -1;
        for(int i=0; i<n; i++) {
            if(vertex[i] == -1) {
                return -1;
            }
            max = Math.max(max, vertex[i]);
        }
        
        return max;
    }
    
//     private int dijkstra(int[][] times, int n, int k) {
        
//     }
    
//     private int floydwarshall(int[][] times, int n, int k) {
        
//     }
}