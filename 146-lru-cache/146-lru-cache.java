class LRUCache {
    LinkedHashMap<Integer, Integer> hash;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        this.hash = new LinkedHashMap<>(capacity);
        this.CAPACITY = capacity;
    }

    public int get(int key) {
        Integer val = hash.get(key);
        if(val != null) {
            hash.remove(key);
            hash.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hash.get(key) == null && hash.size() == this.CAPACITY) {
            hash.remove(hash.keySet().iterator().next());
        } else {
            // linked hash map does not put the value on top automatically, you must remove and reput.
            hash.remove(key);
        }
        hash.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 */