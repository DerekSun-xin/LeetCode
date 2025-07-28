class Twitter:

    def __init__(self):
        self.my_dict = {}
        self.index = 0
        self.follows = {}
        
    def postTweet(self, userId: int, tweetId: int) -> None:
        self.index+=1
        if userId in self.my_dict:   
            self.my_dict[userId].append((tweetId,self.index))
        else:
            self.my_dict[userId] = [(tweetId,self.index)]     

        if userId not in self.follows:
            self.follows[userId] = {userId}


    def getNewsFeed(self, userId: int) -> List[int]:
        self.totalNews = []
        if userId in self.follows:
            for followeeId in self.follows[userId]:
                if followeeId in self.my_dict:
                    self.totalNews.extend(self.my_dict[followeeId][-10:])
        self.totalNews = sorted(self.totalNews,key=lambda x:x[1],reverse=True)
        res = []
        for val,index in self.totalNews[:10]:
            res.append(val)
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.follows:
            self.follows[followerId].add(followeeId)
        else:
            self.follows[followerId] = {followerId,followeeId}

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.follows:
            self.follows[followerId].discard(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)