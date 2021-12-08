class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOranges = findOrange(grid);
        orangesRottingHelper(grid, rottenOranges);
        // printGrid(grid);
        return findMinutes(grid);
    }
    
    /*
     * Find the rotten oranges
     */
    private Queue<int[]> findOrange(int[][] grid) {
        Queue<int[]> oranges = new LinkedList<>();
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 2) {
                    oranges.add(new int[]{row,col});
                }
            }
        }
        return oranges;
    }
        
        
    private void orangesRottingHelper(int[][] grid, Queue<int[]> rottenOranges) {
        if(rottenOranges.isEmpty()) {
            return;
        }
        int[] indexOfOrange = rottenOranges.remove();
        int i = indexOfOrange[0], j = indexOfOrange[1];
        int currentMin = grid[i][j];
        // top
        if(i-1 >= 0 && grid[i-1][j] == 1) {
            grid[i-1][j] = currentMin + 1;
            rottenOranges.add(new int[]{i-1,j});
        }
        // left
        if(j-1 >= 0 && grid[i][j-1] == 1) {
            grid[i][j-1] = currentMin + 1;
            rottenOranges.add(new int[]{i,j-1});
        }
        // bottom
        if(i+1 < grid.length && grid[i+1][j] == 1) {
            grid[i+1][j] = currentMin + 1;
            rottenOranges.add(new int[]{i+1,j});
        }
        // right
        if(j+1 < grid[0].length && grid[i][j+1] == 1) {
            grid[i][j+1] = currentMin + 1;
            rottenOranges.add(new int[]{i,j+1});
        }
        orangesRottingHelper(grid, rottenOranges);
    }
    
    private int findMinutes(int[][] grid) {
        int max = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    return -1;
                } else if(grid[row][col] > max) {
                    max = grid[row][col];
                }
            }
        }
        return max == 0 ? 0 : max-2;
    }
    
    private void printGrid(int[][] grid) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();
        }
    }
}