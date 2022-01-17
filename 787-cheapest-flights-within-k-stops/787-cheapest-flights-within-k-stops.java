class Solution {
    public int findCheapestPrice(int cities, int[][] flights, int src, int dst, int transfers) {
        // return dfs(cities, flights, src, dst, transfers);
        // return bfs(cities, flights, src, dst, transfers);
        return bellmanFord(cities, flights, src, dst, transfers);
        // return dijkstra(cities, flights, src, dst, transfers);
    }
    
    // DFS - Time Limit Exceeded - works though
    private int dfs(int cities, int[][] flights, int src, int dst, int transfers) {
        HashMap<Integer, List<Pair<Integer, Integer>>> hashMap = convertToHashMap(flights);
        int price = dfsHelper(hashMap, src, dst, transfers);
        return price == Integer.MAX_VALUE ? -1 : price;
    }

    private int dfsHelper(HashMap<Integer, List<Pair<Integer, Integer>>> hashMap, int src, int dst, int transfers) {
        // ran out of transers or no stop here
        if(transfers == -2) {
            return Integer.MAX_VALUE;   // ran out of transfers
        } else if(src == dst) {
            return 0;
        } else if(!hashMap.containsKey(src)) {
            return Integer.MAX_VALUE;   // no stops here
        }
        
        List<Pair<Integer,Integer>> srcDirections = hashMap.get(src);
        int minPrice = Integer.MAX_VALUE, newSrc, price, p;
        
        for(int i = 0; i<srcDirections.size(); i++) {
            newSrc = srcDirections.get(i).getKey();
            p = dfsHelper(hashMap, newSrc, dst , transfers-1);
            if(p != Integer.MAX_VALUE) {
                price = srcDirections.get(i).getValue();
                minPrice = Math.min(p + price, minPrice);
            }
        }
        
        return minPrice;
    }
    
    private HashMap<Integer, List<Pair<Integer, Integer>>> convertToHashMap(int[][] flights) {
        // key is src, pair -> dst, price
        HashMap<Integer, List<Pair<Integer, Integer>>> rtn = new HashMap<>();
        
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0], dst = flights[i][1], price = flights[i][2];
            Pair<Integer, Integer> pair = new Pair(dst, price);
            if(rtn.containsKey(src)) {
                rtn.get(src).add(pair);
            } else {
                List<Pair<Integer, Integer>> lst = new ArrayList<>();
                lst.add(pair);
                rtn.put(src, lst);
            }
        }
        return rtn;
    }
    
    // BFS - Time Limit Exceeded - works though
    private int bfs(int cities, int[][] flights, int src, int dst, int transfers) {
        Queue<int[]> queue = new LinkedList<>();
        addToQueue(queue, flights, src);
        int minPrice = Integer.MAX_VALUE;
        
        // loop the transfers
        for(int i=0; i<transfers+1; i++) {
            int queueSize = queue.size();
            for(int j=0; j<queueSize; j++) {
                int[] curr = queue.poll();
                int dest = curr[1], price = curr[2];
                if(dest == dst) {
                    minPrice = Math.min(minPrice, price);
                } else {
                    for(int k=0; k<flights.length; k++) {
                        if(flights[k][0] == dest && flights[k][2] + price < minPrice) {
                            queue.add(new int[]{flights[k][0], flights[k][1], flights[k][2] + price});
                        }
                    }
                }
            }
        }
        
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }
    
    private void addToQueue(Queue<int[]> queue, int[][] flights, int src) {
        for(int i=0; i<flights.length; i++) {
            if(flights[i][0] == src) {
                queue.add(flights[i]);
            }
        }
    }
    
    // BELLMANFORD - works
    private int bellmanFord(int cities, int[][] flights, int src, int dst, int transfers) {
        int[] dp = new int[cities];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        
        for(int i=0; i<transfers+1; i++) {
                int[] dpTemp = dp.clone();
                for(int j=0; j<flights.length; j++) {
                    int s = flights[j][0], d = flights[j][1], p = flights[j][2];
                    dpTemp[d] = Math.min(dpTemp[d], dp[s] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[s] + p);
                }
            dp = dpTemp;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
    
    // DIJKSTRA - Time Limit Exceeded - works though
    private int dijkstra(int cities, int[][] flights, int src, int dst, int transfers) {
        int flightsLen = flights.length;
        Queue<Flight> minHeap = new PriorityQueue<>(new SortFlightByPrice());
        
        putInQueue(minHeap, flights, src, 0, transfers+1);
        
        while(!minHeap.isEmpty()) {
            Flight flight = minHeap.poll();
            if(flight.dst == dst) {
                return flight.price;
            } else if(flight.transfers != 0) {
                putInQueue(minHeap, flights, flight.dst, flight.price, flight.transfers);
            }
        }
        
        return -1;
    }
    
    private void putInQueue(Queue<Flight> queue, int[][] flights, int src, int price, int transfers) {
        for(int i=0; i<flights.length; i++) {
            int s = flights[i][0];
            if(s == src) {
                int d = flights[i][1], p = flights[i][2];
                Flight f = new Flight(s, d, p+price, transfers-1);
                queue.add(f);
            }
        }
    }
}

class Flight {
    int src;
    int dst;
    int price;
    int transfers;
    
    public Flight(int src, int dst, int price, int transfers) {
        this.src = src;
        this.dst = dst;
        this.price = price;
        this.transfers = transfers;
    }
}

class SortFlightByPrice implements Comparator<Flight> {
    @Override
    public int compare(Flight f1, Flight f2) {
        return Integer.compare(f1.price, f2.price);
    }
}


/*
    
5
[[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]
2
1
1


3
[[0,1,100],[1,2,100],[0,2,500]]
0
2
1


3
[[0,1,100],[1,2,100],[0,2,500]]
0
2
0


11
[[0,3,3],[3,4,3],[4,1,3],[0,5,1],[5,1,100],[0,6,2],[6,1,100],[0,7,1],[7,8,1],[8,9,1],[9,1,1],[1,10,1],[10,2,1],[1,2,100]]
0
2
4

17
[[0,12,28],[5,6,39],[8,6,59],[13,15,7],[13,12,38],[10,12,35],[15,3,23],[7,11,26],[9,4,65],[10,2,38],[4,7,7],[14,15,31],[2,12,44],[8,10,34],[13,6,29],[5,14,89],[11,16,13],[7,3,46],[10,15,19],[12,4,58],[13,16,11],[16,4,76],[2,0,12],[15,0,22],[16,12,13],[7,1,29],[7,14,100],[16,1,14],[9,6,74],[11,1,73],[2,11,60],[10,11,85],[2,5,49],[3,4,17],[4,9,77],[16,3,47],[15,6,78],[14,1,90],[10,5,95],[1,11,30],[11,0,37],[10,4,86],[0,8,57],[6,14,68],[16,8,3],[13,0,65],[2,13,6],[5,13,5],[8,11,31],[6,10,20],[6,2,33],[9,1,3],[14,9,58],[12,3,19],[11,2,74],[12,14,48],[16,11,100],[3,12,38],[12,13,77],[10,9,99],[15,13,98],[15,12,71],[1,4,28],[7,0,83],[3,5,100],[8,9,14],[15,11,57],[3,6,65],[1,3,45],[14,7,74],[2,10,39],[4,8,73],[13,5,77],[10,0,43],[12,9,92],[8,2,26],[1,7,7],[9,12,10],[13,11,64],[8,13,80],[6,12,74],[9,7,35],[0,15,48],[3,7,87],[16,9,42],[5,16,64],[4,5,65],[15,14,70],[12,0,13],[16,14,52],[3,10,80],[14,11,85],[15,2,77],[4,11,19],[2,7,49],[10,7,78],[14,6,84],[13,7,50],[11,6,75],[5,10,46],[13,8,43],[9,10,49],[7,12,64],[0,10,76],[5,9,77],[8,3,28],[11,9,28],[12,16,87],[12,6,24],[9,15,94],[5,7,77],[4,10,18],[7,2,11],[9,5,41]]
13
4
13


13
[[11,12,74],[1,8,91],[4,6,13],[7,6,39],[5,12,8],[0,12,54],[8,4,32],[0,11,4],[4,0,91],[11,7,64],[6,3,88],[8,5,80],[11,10,91],[10,0,60],[8,7,92],[12,6,78],[6,2,8],[4,3,54],[3,11,76],[3,12,23],[11,6,79],[6,12,36],[2,11,100],[2,5,49],[7,0,17],[5,8,95],[3,9,98],[8,10,61],[2,12,38],[5,7,58],[9,4,37],[8,6,79],[9,0,1],[2,3,12],[7,10,7],[12,10,52],[7,2,68],[12,2,100],[6,9,53],[7,4,90],[0,5,43],[11,2,52],[11,8,50],[12,4,38],[7,9,94],[2,7,38],[3,7,88],[9,12,20],[12,0,26],[10,5,38],[12,8,50],[0,2,77],[11,0,13],[9,10,76],[2,6,67],[5,6,34],[9,7,62],[5,3,67]]
10
1
10


10
[[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
6
0
7
*/