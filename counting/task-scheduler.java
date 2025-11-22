class Solution {
    public int leastInterval(char[] tasks, int n) {
        int intervals = 0; 
        int windowSize = n + 1; 
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task: tasks){
            map.put(task, map.getOrDefault(task, 0) + 1); 
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        for (Integer value: map.values()){
            maxHeap.add(value); 
        }
        while (!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>(); 
            for(int i = 0; i < windowSize; i++){
                if (!maxHeap.isEmpty()){
                    int value = maxHeap.poll();
                    if (--value > 0){
                        temp.add(value); 
                    }
                    intervals += 1; 
                }else{
                    if (temp.size() == 0){
                        break; 
                    }else{
                        intervals += 1; 
                    }
                }
            }

            for (int val: temp){
                maxHeap.add(val); 
            }
        }
        return intervals; 
    }
}