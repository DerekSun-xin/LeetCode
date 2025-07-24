class LRUCache {
    int capacity;
    ListNode head = new ListNode();
    ListNode tail = new ListNode(); 
    HashMap<Integer, ListNode> map = new HashMap<>(); 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            ListNode cur = map.get(key);
            ListNode prev = cur.prev;
            ListNode next = cur.next; 
            prev.next = next;
            next.prev = prev; 
            ListNode lastNode = tail.prev; 
            lastNode.next = cur;
            cur.prev = lastNode;
            cur.next = tail;
            tail.prev = cur; 
            return cur.val;
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
        }else{
            if (map.size() == capacity){
                // Evict the LRU 
                ListNode nodeDel = head.next; 
                if (nodeDel != null && nodeDel != tail){
                    map.remove(nodeDel.key); 
                }
                ListNode next = nodeDel.next; 
                head.next = next;
                next.prev = head; 
            }
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode); 
            ListNode last = tail.prev;
            newNode.prev = last;
            last.next = newNode; 
            newNode.next = tail; 
            tail.prev = newNode; 
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode() {
        this.key = -2;
        this.val = -2;
    }

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */