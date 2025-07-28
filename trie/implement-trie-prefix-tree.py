class Trie:

    def __init__(self):
        self.ls = []
        return

    def insert(self, word: str) -> None:
        self.ls.append(word)
        return 

    def search(self, word: str) -> bool:
        if word in self.ls:
            return True
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        length = len(prefix)
        if length == 0:
            return True
        for value in self.ls:
            if value[:length] == prefix:
                return True
        return False


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)