class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        
        for(int i=0; i<strs.length; i++) {
            String original = strs[i];
            char tempChar[] = original.toCharArray();
            Arrays.sort(tempChar);
            String sorted = new String(tempChar);
            
            if(hash.containsKey(sorted)) {
                hash.get(sorted).add(original);
            } else {
                List<String> newLst = new ArrayList<>();
                newLst.add(original);
                hash.put(sorted, newLst);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(List<String> lst: hash.values()) {
            result.add(lst);
        }
        
        return result;
    }
}

/*
 * Go through the array, sort the strings, put the sorted as key
 */