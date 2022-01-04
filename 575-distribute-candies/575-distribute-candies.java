class Solution {
    public int distributeCandies(int[] candyType) {
        int amtCandies = candyType.length;
        
        // Using set bc don't know if array is sorted
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<amtCandies; i++) {
            set.add(candyType[i]);
        }
        
        return Math.min(amtCandies/2, set.size());
    }
}