class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxHeap =[-s for s in stones]
        heapq.heapify(maxHeap)
        while len(maxHeap) > 1: 
           max1 = heapq.heappop(maxHeap)
           max2 = heapq.heappop(maxHeap)
           diff = -max1+max2
           heapq.heappush(maxHeap, -diff)
        return -maxHeap[0]

        
        