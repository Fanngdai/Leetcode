class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, new Integer(0));
        
        // Init hashmap, for looping
        for(int[] relation : prerequisites) {
            int prereq = relation[1], course = relation[0];
            inDegree[course]+=1;
            if(adjMap.containsKey(prereq)) {
                adjMap.get(prereq).add(course);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(course);
                adjMap.put(prereq, temp);
            }
        }
        
        while(canFinishHelper(adjMap, inDegree));
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i]!=-1)
                return false;
        }
        return true;
    }
    
    private boolean canFinishHelper(Map<Integer, List<Integer>> adjMap, int[] inDegree) {
        boolean found = false;
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) {
                found = true;
                inDegree[i]--;
                if(adjMap.containsKey(i)) {
                    for(int j: adjMap.get(i)) {
                        inDegree[j]--;
                    }
                }
            }
        }
        return found;
    }
    
    
}