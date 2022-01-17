class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fLen = firstList.length, sLen = secondList.length;
        if(fLen == 0 || sLen == 0) {
            return new int[][]{};
        }
        
        List<int[]> rtn = new ArrayList<>();
        int fCnt = 0, sCnt = 0;
        int[] compare = null;
        
        while(fCnt < fLen && sCnt < sLen) {
            int[] f = firstList[fCnt];
            int[] s = secondList[sCnt];
            
            // get the smaller of the 2 -> len++
            if(f[0] == s[0]) {
                compare = intervalIntersectionHelper(rtn, f, s);
                fCnt++;
                sCnt++;
            } else if(f[0] < s[0]) {
                compare = intervalIntersectionHelper(rtn, compare, f);
                fCnt++;
            } else {
                compare = intervalIntersectionHelper(rtn, compare, s);
                sCnt++;
            }
        }
        
        while (fCnt < fLen) {
            intervalIntersectionHelper(rtn, compare, firstList[fCnt]);
            fCnt++;
        }
        while (sCnt < sLen) {
            intervalIntersectionHelper(rtn, compare, secondList[sCnt]);
            sCnt++;
        }
        
        return rtn.stream().toArray(int[][]::new);
    }
    
    private int[] intervalIntersectionHelper(List<int[]> lst, int[] f, int[] s) {
        if(f == null || f[1] < s[0]) {
            // doesn't overlap
            return s;
        } else if(f[0] <= s[0] && f[1] >= s[1]) {
            // s overlaps f
            lst.add(s);
        } else if(f[1] >= s[0]) {
            // overlaps
            lst.add(new int[]{s[0], Math.min(f[1],s[1])});
            f = s[1] >= f[1] ? s : f;
        }
        return f[1] > s[1] ? f : s;
    }
}

/*
Cases
1. it doesn't overlap at all
[[1,4],[5,9]]
[[10,12],[13,15],[16,20]]
2. it starts at the same but not end at the same
[[1,3]]
[[1,4],[5,6]]

[[1,8]]
[[1,4],[5,6]]
3. it starts and end at the same
[[0,2],[5,10],[15,24],[26,30]]
[[1,5],[8,12],[15,24],[25,26]]
4. it doesn't start at the same but ends at the same
[[0,2],[5,10],[13,23],[24,30]]
[[1,5],[8,12],[15,24],[25,30]]
5. one overlaps a few
[[0,1000]]
[[1,5],[8,12],[15,24],[25,30],[60,80]]
6. it overlaps
7. it only overlaps at one digit
[[1,5],[11,20],[26,30]]
[[6,10],[20,25],[31,40]]

[[0,2],[5,10],[13,23],[24,25]]
[[1,5],[8,12],[15,24],[25,26]]
[[1,3],[5,9]]
[]
[[1,4]]
[[1,3],[4,5]]

*/