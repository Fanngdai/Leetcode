class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort by h first, then sort by k
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0]-a[0] : a[1]-b[1]);
        
        // put it in based on location,  shift everyone else back
        List<int[]> lst = new ArrayList<int[]>();
        for(int i=0; i<people.length; i++) {
            lst.add(people[i][1], people[i]);
        }
        
        return lst.toArray(new int[people.length][2]);
    }
}

// [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
// [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
// [[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]