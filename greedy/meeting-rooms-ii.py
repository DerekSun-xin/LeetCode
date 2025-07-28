class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        newlist = sorted(intervals,key=lambda x:x[0])
        if len(intervals)==0:
            return 0 
        print(newlist)
        numRoom = 1
        start_time = 0
        end_time = 0
        end_storage = collections.deque([0])
        for ls in newlist:
            start_time = ls[0]
            if start_time<end_time:
                if end_storage:
                    tmp = end_storage[0]
                    if start_time>=tmp:
                        end_storage.remove(tmp)
                    else:
                        numRoom+=1
                end_storage.append(ls[1])
                end_storage = sorted(end_storage)
            else:
                end_storage.remove(end_time)
                end_storage.append(ls[1])
                end_storage = sorted(end_storage)             
            end_time = ls[1]
        return numRoom