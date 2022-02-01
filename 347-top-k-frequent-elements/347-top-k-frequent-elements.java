class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // put in hashmap, for counting purpose
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        
        // put in max heap
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>
            ((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> map: hashMap.entrySet()) {
            Pair<Integer, Integer> temp = new Pair<>(map.getKey(), map.getValue());
            queue.add(temp);
        }
        
        // get values from max heap
        int[] rtn = new int[k];
        for(int i=0; i<k; i++) {
            rtn[i] = queue.poll().getKey();
        }
        
        return rtn;
    }
}