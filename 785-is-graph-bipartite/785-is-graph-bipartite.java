class Solution {
    public boolean isBipartite(int[][] graph) {
        int graphLen = graph.length;
        
        boolean[] color = new boolean[graphLen];
        boolean[] visited = new boolean[graphLen];
        Arrays.fill(visited, false);
        
        for(int i=0; i<graphLen; i++) {
            if(!visited[i] && !isBipartiteHelper(graph, color, visited, i, true))
                return false;
        }
        
        return true;
    }
    
    /*
     * Can write this in non recursion way
     * 
     * Logic: In parent method, I loop through all the nodes that are not visited,
     * in case there are graphs that are not connected
     *
     * In this method, if the node is already visited, it mean we have already looked into it
     * but in the case that it is next to a node that is the same boolean value. It would return false
     * This is handled in the base case
     *
     * If the node is not visited, we set the color to true or false, whatever the adjecent node is not.
     * we set visited to true, bc we will now iterate through all it's adjecent node, checking for color.
     *
     * Space    O(2graphLen)        can use int instead, 0 means not visited, 1 means one color, 2 mean other color
     * time     O(edge*vertex)
     */
    private boolean isBipartiteHelper(int[][] graph, boolean[] color, boolean[] visited, int pos, boolean currColor) {
        if(visited[pos]) {
            return color[pos] ^ currColor ? false : true;
        }
        color[pos] = currColor;
        visited[pos] = true;
        boolean flag = true;
        
        for(int i=0; i<graph[pos].length; i++) {
            if(!isBipartiteHelper(graph, color, visited, graph[pos][i], !currColor)) {
                return false;
            }
        }
        
        return true;
    }
}

/*
    what it return if not connected
*/