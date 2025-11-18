class Solution {
    public int lastStoneWeight(int[] stones) {
        // Use max-heap 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        for (int stone: stones){
            pq.add(stone); 
        }
        while (pq.size() != 1){
            int heaviest = pq.poll();
            int secondHeaviest = pq.poll();
            int diff = heaviest - secondHeaviest;
            if (diff >= 0){
                pq.add(diff); 
            }
        }
        return pq.peek(); 
    }
}