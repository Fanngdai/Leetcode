class Solution {
    public String frequencySort(String s) {
        if(s.length() <2) return s;
        
        Map<Character, CharFreq> hashMap = new HashMap<>();
        
        // put it in the queue
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(hashMap.containsKey(c)) {
                hashMap.get(c).addFreq();
            } else {
                CharFreq cf = new CharFreq(c);
                hashMap.put(c, cf);
            }
        }
        
        Queue<CharFreq> maxHeap = new PriorityQueue<>(new Comparator<CharFreq>() {
            @Override
            public int compare(CharFreq c1, CharFreq c2) {
                return c2.freq - c1.freq;
            }
        });
        
        for(Map.Entry<Character, CharFreq> set : hashMap.entrySet()) {
            maxHeap.add(set.getValue());
        }
        
        StringBuilder rtn = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            CharFreq cf = maxHeap.poll();
            char c = cf.c;
            for(int i=0; i<cf.freq; i++) {
                rtn.append(c);
            }
        }
        
        return rtn.toString();
    }
}

class CharFreq {
    int freq;
    char c;
    
    public CharFreq(char c) {
        this.c = c;
        this.freq = 1;
    }
    
    public void addFreq() {
        this.freq++;
    }
}