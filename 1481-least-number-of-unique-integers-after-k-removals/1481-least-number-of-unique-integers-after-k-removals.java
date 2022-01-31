class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> map: hashMap.entrySet()) {
            pq.add(map.getValue());
        }
        
        while(k>0) {
            k -= pq.poll();
        }
        
        return k<0 ? pq.size()+1 : pq.size();
    }
}