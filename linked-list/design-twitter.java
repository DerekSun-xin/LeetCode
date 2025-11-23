class ListNode {
    int counter; 
    int tweetId; 
    ListNode next; 
}

class Twitter {
    HashMap<Integer, Set<Integer>> relation; 
    HashMap<Integer, ListNode> tweets; 
    int counter;

    public Twitter() {
        relation = new HashMap<>(); 
        tweets = new HashMap<>(); 
        counter = 0; 
    }
    

    public void postTweet(int userId, int tweetId) {
        // O(1)
        ListNode node = new ListNode();
        node.counter = counter;
        node.tweetId = tweetId; 
        ListNode head = tweets.get(userId);
        node.next = head;
        tweets.put(userId, node);
        counter++;  
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // O(logk)
        List<Integer> newsFeed = new ArrayList<>(); 
        Set<Integer> followees = relation.get(userId) != null ? relation.get(userId): new HashSet<>(); 
        followees.add(userId); 
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.counter, a.counter)); 
        for (Integer followee: followees){
            ListNode node = tweets.get(followee); 
            pq.add(node); 
        }
        
        while (newsFeed.size() < 10 && !pq.isEmpty()){
            ListNode node = pq.poll(); 
            newsFeed.add(node.tweetId);
            if (node.next != null){
                pq.add(node.next); 
            }
        }
        return newsFeed; 
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> curRelation = relation.getOrDefault(followerId, new HashSet<>()); 
        curRelation.add(followeeId); 
        relation.put(followerId, curRelation); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> curRelation = relation.getOrDefault(followerId, new HashSet<>()); 
        curRelation.remove(followeeId); 
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */