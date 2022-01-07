class UndergroundSystem {
    // id, StationName, time
    HashMap<Integer, Pair<String, Integer>> checkIn;
    // to from, total time, amt rides
    HashMap<Pair<String,String>, int[]> routes;

    public UndergroundSystem() {
        checkIn = new HashMap<>();
        routes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String checkInStation = checkIn.get(id).getKey();
        int checkInTime = checkIn.get(id).getValue();
        checkIn.remove(id);
        
        Pair<String, String> toFrom = new Pair(checkInStation, stationName);
        int[] time = routes.getOrDefault(toFrom, new int[2]);
        
        time[0] += t - checkInTime;
        time[1]++;
        routes.put(toFrom, time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] r = routes.get(new Pair(startStation, endStation));
        return (double)r[0]/r[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */