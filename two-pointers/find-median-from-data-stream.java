class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap; 
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
    }
    
    public void addNum(int num) {
        maxHeap.add(num); 
        minHeap.add(maxHeap.poll()); 
        if (minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll()); 
        }
    }
    
    public double findMedian() {
        Integer size = maxHeap.size() + minHeap.size();
        if (size % 2 == 0){
            Integer sum = maxHeap.peek() + minHeap.peek(); 
            return sum / 2.0; 
        }else{
            return maxHeap.peek(); 
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */