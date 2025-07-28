class Solution:
    def distance(self, x , y):
        return  math.sqrt(x ** 2 + y ** 2)

    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        ret = []
        heap = [] 
        for point in points:
            dist = self.distance(point[0], point[1]) 
            tup = (dist, point[0], point[1])
            heapq.heappush(heap, tup)
        for _ in range(k):
            min_ele = heapq.heappop(heap)
            ret.append([min_ele[1],min_ele[2]])
        return ret

