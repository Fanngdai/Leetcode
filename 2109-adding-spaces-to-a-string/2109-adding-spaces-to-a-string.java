class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder rtn = new StringBuilder();
        int index = 0;
        for(int i: spaces) {
            rtn.append(s.substring(index, i)).append(" ");
            index = i;
        }
        rtn.append(s.substring(index, s.length()));
        
        return rtn.toString();
    }
}