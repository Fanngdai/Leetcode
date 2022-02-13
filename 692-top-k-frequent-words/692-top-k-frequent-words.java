class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> counter = new HashMap<>();
        int wLen = words.length;
        
        for(int i=0; i<wLen; i++) {
            counter.put(words[i], counter.getOrDefault(words[i], 0) + 1);
        }
        
        PriorityQueue<Pair<String, Integer>> heap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue() != 0 ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey()));
        
        
        for(Map.Entry ele: counter.entrySet()) {
            Pair<String, Integer> pair = new Pair<>((String)ele.getKey(), (Integer)ele.getValue());
            heap.add(pair);
        }
        
        List<String> rtn = new ArrayList<>();
        for(int i=0; i<k; i++) {
            rtn.add(heap.poll().getKey());    
        }
        
        return rtn;
    }
}