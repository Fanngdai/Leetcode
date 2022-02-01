class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i: arr) {
            hash.put(i, hash.getOrDefault(i,0)+1);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(hash.containsKey(val)) {
                if(hash.get(val) == 1) {
                    hash.remove(val);
                } else {
                    hash.put(val, hash.get(val)-1);
                }
                
                if(val < 0 && val%2==0) {
                    val /= 2;
                } else {
                    val *= 2;
                }
                
                if(hash.containsKey(val)) {
                    if(hash.get(val) == 1) {
                        hash.remove(val);
                    } else {
                        hash.put(val, hash.get(val)-1);
                    }
                } else {
                    return false;
                }
                
            }
        }
        
        return true;
    }
}

/*
[3,1,3,6]
[2,1,2,6]
[4,-2,2,-4]
[0,0,0,0,0,0]
[-5,-2]
*/