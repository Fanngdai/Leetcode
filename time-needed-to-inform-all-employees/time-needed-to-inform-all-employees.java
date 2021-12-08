class Solution {
    // DFS
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // key is manager, val is all the reports
        Map<Integer, List<Integer>> managerMap = new HashMap<>();
        
        // fill in managerMap, also look for the root, which is when the manager is -1. No put into lst
        int root = -1;
        for(int i=0; i<n; i++) {
            if(manager[i] == -1) {
                root = i;
            } else if(managerMap.containsKey(manager[i])) {
                managerMap.get(manager[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                managerMap.put(manager[i], temp);
            }
            
        }
        
        return numOfMinutesHealper(root, managerMap, informTime);
    }
    
    private int numOfMinutesHealper(int manager, Map<Integer, List<Integer>> managerMap, int[] informTime) {        
        List<Integer> reports = managerMap.get(manager);
        managerMap.remove(manager);
        int time = informTime[manager];
        
        if(reports == null || reports.isEmpty()) {
            return 0;
        }
        
        int max = time;
        for(Integer i : reports) {
            max = Math.max(numOfMinutesHealper(i, managerMap, informTime) + time, max);
        }
        
        return max;
    }
}