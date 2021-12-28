class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();
        if(s2Len<s1Len) return false;
        
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        
        for(int i=0; i<s1Len; i++) {
            s1Arr[s1.charAt(i)-'a']++;
            s2Arr[s2.charAt(i)-'a']++;
        }
        
        for(int i=s1Len; i<s2Len; i++) {
            if(Arrays.equals(s1Arr,s2Arr)) return true;
            s2Arr[s2.charAt(i-s1Len)-'a']--;
            s2Arr[s2.charAt(i)-'a']++;
        }
        
        return Arrays.equals(s1Arr,s2Arr);
        // return permutation(s1.toCharArray(), s2, 0);
    }
    
    private boolean permutation(char[] s1, String s2, int index) {
        if(s2.contains(new String(s1)))
            return true;
        
        for(int i=index+1; i<s1.length; i++) {
            swap(s1, index, i);
            if(permutation(s1, s2, index+1)) {
                return true;
            }
            swap(s1, index, i);
        }
        
        return false;
    }
    
    private void swap(char[] s1, int a, int b) {
        char temp = s1[a];
        s1[a] = s1[b];
        s1[b] = temp;
    }
    
}

/*
 * Legit did this problem bc permutation practice WHY IS ITTT NOT PERMUTATION AIYAAAAA
 */

// "ab"
// "eidbaooo"
// "ab"
// "eidboooba"
// "ab"
// "eidboaoo"
// "dinitrophenylhydrazine"
// "acetylphenylhydrazine"