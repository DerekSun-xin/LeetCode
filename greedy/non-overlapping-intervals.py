class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[1])
        removed = 0
        i=1
        while i<len(intervals):
            cur_interval = intervals[i]
            last_interval = intervals[i-1]
            if cur_interval[0]<last_interval[1]:
                intervals.pop(i)
                removed+=1
            else:
                i+=1
        return removed
            
               

            