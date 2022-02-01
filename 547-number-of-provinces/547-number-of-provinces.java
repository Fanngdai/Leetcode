class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> set = new HashSet<>();
        int rtn = 0;
        
        for(int i=0; i<isConnected.length; i++) {
            if(!set.contains(i)) {
                visitCities(isConnected, set, i);
                rtn++;
            }
        }
        
        return rtn;
    }
    
    private void visitCities(int[][] isConnected, Set<Integer> set, int city) {
        set.add(city);
        
        for(int i=0; i<isConnected[city].length; i++) {
            if(isConnected[city][i] == 1 && !set.contains(i)) {
                visitCities(isConnected, set, i);
            }
        }
    }
}