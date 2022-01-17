class Solution {
    public int numSimilarGroups(String[] strs) {
        int strsLen = strs.length;
        if(strsLen < 2) return 1;
        
        UnionFind unionFind = new UnionFind(strsLen);
        
        for(int i=0; i<strsLen; i++) {
            for(int j=i+1; j<strsLen; j++) {
                // already unioned
                if(unionFind.find(i) == unionFind.find(j)) {
                    continue;
                }
                String str1 = strs[i];
                String str2 = strs[j];
                if(isSimilar(str1, str2)) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getGroups();
    }
    
    private boolean isSimilar(String a, String b) {
        int count = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i) && ++count > 2) {
                return false;
            }
        }
        return true;
    }
}

class UnionFind {
    private int groups;
    private int[] parents;
    
    public UnionFind(int groups) {
        this.groups = groups;
        this.parents = new int[groups];
        
        for(int i=0; i<groups; i++) {
            parents[i] = i;
        }
    }
    
    // find the parent/root, also compress the chart, so all child will have 1 parent
    public int find(int x) {
        while(parents[x] != x) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
    
    // find the parent of x and y, if the parents are not the same, then point them tg
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot != yRoot) {
            parents[xRoot] = yRoot;
            groups--;
        }
    }
    
    public int getGroups() {
        return this.groups;
    }
}