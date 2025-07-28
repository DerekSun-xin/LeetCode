class RandomizedSet {
    //Create a list to store elements
    private ArrayList<Integer> list;
    //Create a hashmap to map elements to its index in the list above
    private HashMap<Integer,Integer> map; 
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        list.add(val);
        //Add the val at the end of the list
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        } 
        //To ensure the remove can be done in O(1), we need to swap the elements to be removed with the last element in the list&map.
        int index = map.get(val); // Get the index of val in list
        int last_index = list.size()-1; 
        int last_val = list.get(last_index);
        
        if (last_index==-1){
            return false;
        }

        list.set(index,last_val);
        map.put(last_val,index);
        
        map.remove(val);
        list.remove(last_index);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */