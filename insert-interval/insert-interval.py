class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        self.insertNewInterval(intervals, newInterval)
        # for i in range(len(intervals)):
        #     print(intervals[i][0], "\t", intervals[i][1])
        index = 1
        while index != len(intervals):
            prev = intervals[index-1]
            curr = intervals[index]
            
            # prev is greater than
            if prev[1] >= curr[1]:
                intervals.pop(index)
            # is consecutive
            elif prev[1] >= curr[0]:
                intervals[index-1] = [prev[0],curr[1]]
                intervals.pop(index)
            else:
                index += 1
        return intervals
            
    def insertNewInterval(self, intervals: List[List[int]], newInterval: List[int]):
        if len(intervals) == 0:
            intervals.append(newInterval)
            return intervals
        # after the last
        elif intervals[len(intervals)-1][0] < newInterval[0] or intervals[len(intervals)-1][0] == newInterval[0] and intervals[len(intervals)-1][1] < newInterval[1]:
            intervals.insert(len(intervals), newInterval)
            return intervals
        for i in range(len(intervals)):
            if intervals[i][0] > newInterval[0]:
                if i == 0:
                    intervals.insert(0, newInterval)
                    break
                else:
                    intervals.insert(i, newInterval)
                    break
        return intervals
        
# [[1,3],[6,9]]
# [2,5]
# [[1,2],[3,5],[6,7],[8,10],[12,16]]
# [4,8]
# []
# [5,7]
# [[1,5]]
# [1,7]
# [[1,3],[6,9]]
# [7,10]