class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda i: i[0])
        output = [intervals[0]]
        for i in range(1,len(intervals)):
            front, end = intervals[i]
            if front > output[-1][1]:
                output.append([front,end])
            else:
                    output[-1][1] = max(output[-1][1], end)
        return output        