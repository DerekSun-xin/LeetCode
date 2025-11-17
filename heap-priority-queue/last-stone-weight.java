class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            pq.add(stone); 
        }
        while (pq.size() != 1){
            int largest = pq.poll();
            int secondLargest = pq.poll();
            int diff = largest - secondLargest; 
            if (diff >= 0){
                pq.add(diff); 
            }
        }
        return pq.peek(); 
    }
}