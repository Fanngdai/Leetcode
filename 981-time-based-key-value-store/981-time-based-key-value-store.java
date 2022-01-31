class TimeMap {
    HashMap<String, TreeMap<Integer, String>> hashMap;
    
    public TimeMap() {
        hashMap = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hashMap.containsKey(key)) {
            hashMap.put(key, new TreeMap<>());
        }
        hashMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)) {
            return "";   
        }
        TreeMap<Integer, String> tree = hashMap.get(key);
        Integer t = tree.floorKey(timestamp);
        if(t == null) {
            return "";
        }
        return tree.get(t);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */