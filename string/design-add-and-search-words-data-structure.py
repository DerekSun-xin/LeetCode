class WordDictionary:

    def __init__(self):
        self.ls = []
        

    def addWord(self, word: str) -> None:
        self.ls.append(word)
        return
        

    def search(self, word: str) -> bool:
        if "." not in word:
            if word in self.ls:
                return True
            else:
                return False
        else:
            length = len(word)
            for val in self.ls:
                success = 1
                if len(val)==length:
                    for i in range(length):
                        if word[i]!="." and word[i]!=val[i]:
                            success = 0
                    if success==1:
                        return True
            return False
                            


                        
            

        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)