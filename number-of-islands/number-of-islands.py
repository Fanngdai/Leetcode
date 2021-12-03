class Solution:
    # A function which changes the value in the grid s.t. that island will result in 0's
    def editGrid(self, x, y):
        rowSize = len(self.grid)
        colSize = len(self.grid[0])
        self.grid[x][y] = 0
        
        if y+1<colSize and self.grid[x][y+1] == '1':
            return self.editGrid(x, y+1), self.editGrid(x,y)
        if y-1>=0 and self.grid[x][y-1] == '1':
            return self.editGrid(x, y-1), self.editGrid(x,y)
        if x+1<rowSize and self.grid[x+1][y] == '1':
            return self.editGrid(x+1, y), self.editGrid(x,y)
        if x-1>=0 and self.grid[x-1][y] == '1':
            return self.editGrid(x-1, y), self.editGrid(x,y)
        return
    
    # For testing purposes
    def printGrid(self):
        for row in range(len(self.grid)):
            for col in range(len(self.grid[row])):
                print(self.grid[row][col], end="")
            print()
                
    # The main function which searches for a 1 & convert that entire island to 0's
    def numIslands(self, grid):
        self.grid = grid
        rtn = 0
        
        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] == '1':
                    self.editGrid(row, col)
                    rtn += 1
        return rtn
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        