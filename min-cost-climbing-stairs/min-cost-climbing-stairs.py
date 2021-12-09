class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        total = [None]*len(cost)
        return min(self.minCostClimbingStairsHelper(cost, len(cost)-1, total), self.minCostClimbingStairsHelper(cost, len(cost)-2, total))
        
    def minCostClimbingStairsHelper(self, cost, level, total):
        if level<=1:
            return cost[level]
        if(total[level-1] == None):
            total[level-1] = self.minCostClimbingStairsHelper(cost, level-1, total)
        if(total[level-2] == None):
            total[level-2] = self.minCostClimbingStairsHelper(cost, level-2, total)
        return min(total[level-1], total[level-2]) + cost[level]