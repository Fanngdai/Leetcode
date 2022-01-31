class Solution {
    
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        
        for(int i=0; i<split.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(split[i]);
            split[i] = sb.reverse().toString();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(" ", split));
        return sb.reverse().toString();
    }

}