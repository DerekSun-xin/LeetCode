class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap of size k 
        int[][] ret = new int[k][]; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(getDistance(b), getDistance(a)); 
        }); 
        for (int[] point: points){
            pq.add(point); 
            if (pq.size() > k){
                pq.poll(); 
            }
        }

        for(int i = 0; i < k; i++){
            int[] topK = pq.poll(); 
            ret[i] = topK; 
        }
        return ret; 

    }

    private int getDistance(int[] a){
        int distance = a[0] * a[0] + a[1] * a[1]; 
        return distance; 
    }
}