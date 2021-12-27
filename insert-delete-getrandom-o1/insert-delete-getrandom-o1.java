class RandomizedSet {
    Set<Integer> set;
    int size = 0;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.add(val)) {
            size++;
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(set.remove(val)) {
            size--;
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int ran = (int)(Math.random() * size);
        return (new ArrayList<Integer>(set)).get(ran);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */