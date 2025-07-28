class Logger:
    def __init__(self):
        self.expiry = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.expiry: 
            self.expiry[message] = timestamp + 10 
            return True 
        else: 
            if timestamp < self.expiry[message]:
                return False 
            else: 
                self.expiry[message] = timestamp + 10 
                return True 
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)