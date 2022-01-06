class Solution:
    def knightProbability(self, boardsize: int, amtMove: int, row: int, col: int) -> float:
        if amtMove == 0:
            return 1
        elif boardsize < 3:
            return 0
        
        return self.knightProbabilityHelper(boardsize, amtMove, row, col) / (8**amtMove)
        
    def knightProbabilityHelper(self, boardsize, amtMove, row, col):
        locations = {str(row) + "," + str(col) : 1}
        amt = 0
        
        for i in range(amtMove):
            locations, amt = self.probOfMove(boardsize, locations)
                  
        return amt
        

    # get all the spaces for this one move
    def probOfMove(self, boardsize, locations):
        rtn = {}
        amt = 0
        direction = [[-1,2],[-1,-2],[-2,-1],[-2,1],[1,2],[1,-2],[2,1],[2,-1]]
        for loc in locations:
            lst = loc.split(",")
            row = int(lst[0])
            col = int(lst[1])
            for dir in direction:
                r = row+dir[0]
                c = col+dir[1]
                if self.validDirection(r, c, boardsize):
                    word = str(r) + "," + str(c)
                    if word in rtn:
                        rtn[word] += locations[loc]
                    else:
                        rtn[word] = locations[loc]
                    amt += locations[loc]
        return rtn, amt

    def validDirection(self, row, col, boardsize):
        if row < 0 or row >= boardsize or col < 0 or col >= boardsize:
            return False
        return True

# boardsize: int, amtMove: int, row: int, col: int
# 10
# 13
# 5
# 3