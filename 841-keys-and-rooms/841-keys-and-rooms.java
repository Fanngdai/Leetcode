class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        canVisitAllRoomsHelper(rooms, set, 0);
        return set.size() == rooms.size();
    }
    
    private void canVisitAllRoomsHelper(List<List<Integer>> rooms, Set<Integer> set, int index) {
        set.add(index);
        
        for(int i: rooms.get(index)) {
            if(!set.contains(i)) {
                canVisitAllRoomsHelper(rooms, set, i);
            }
        }
    }
}