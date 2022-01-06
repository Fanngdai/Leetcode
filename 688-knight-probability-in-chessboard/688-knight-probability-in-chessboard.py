class Solution:
    def knightProbability(self, boardsize: int, amtMove: int, row: int, col: int) -> float:
        if amtMove == 0:
            print("###")
            return 1
        elif boardsize < 3:
            return 0
        
        return self.knightProbabilityHelper(boardsize, amtMove, row, col) / (8**amtMove)
        
    def knightProbabilityHelper(self, boardsize, amtMove, row, col):
        locations = {str(row) + "," + str(col) : 1}
        amt = 0
        
        for i in range(amtMove):
            locations, amt = self.probOfMove(boardsize, locations)
            # print(locations,"\t",amt)
                  
        return amt
        

    # get all the spaces for this one move
    def probOfMove(self, boardsize, locations):
        rtn = {}
        amt = 0
        direction = [[-1,2],[-1,-2],[-2,-1],[-2,1],[1,2],[1,-2],[2,1],[2,-1]]
        for loc in locations:
            lst = loc.split(",")
            for dir in direction:
                r = int(lst[0])+dir[0]
                c = int(lst[1])+dir[1]
                if self.validDirection(r, c, boardsize):
                    word = str(r) + "," + str(c)
                    if word in rtn:
                        rtn[word] += locations[loc]
                    else:
                        rtn[word] = locations[loc]
                    amt += locations[loc]
                    # print(loc,"\t",rtn[tuple([r,c])],"\t",amt)
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