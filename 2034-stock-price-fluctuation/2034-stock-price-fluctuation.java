class StockPrice {
    HashMap<Integer, Integer> hashMap;
    int lastestTimeStamp;
    TreeMap<Integer, Set<Integer>> treeMap;

    public StockPrice() {
        hashMap = new HashMap<>();
        treeMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(lastestTimeStamp == 0 || timestamp >= lastestTimeStamp) {
            lastestTimeStamp = timestamp;
        }
        
        if(hashMap.containsKey(timestamp)) {
            int prevPrice = hashMap.get(timestamp);
            Set<Integer> set = treeMap.get(prevPrice);
            set.remove(timestamp);
            if(set.isEmpty()) {
                treeMap.remove(prevPrice);
            }
        }
        
        treeMap.putIfAbsent(price, new HashSet<>());
        treeMap.get(price).add(timestamp);
        hashMap.put(timestamp, price);
    }
    
    public int current() {
        return hashMap.get(lastestTimeStamp);
    }
    
    public int maximum() {
        return treeMap.lastKey();
    }
    
    public int minimum() {
        return treeMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */