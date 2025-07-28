class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if len(intervals) == 0: return True 
        intervals.sort(key = lambda i: i[0])
        tmp_end = intervals[0][1] 
        for i in range(1,len(intervals)): 
            front = intervals[i][0]
            end = intervals[i][1] 
            if front < tmp_end: 
                return False
            tmp_end = end
        return True

        
        