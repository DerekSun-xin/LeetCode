class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        @lru_cache
        def helper(start):
            if start==len(s):
                return True
            for i in range(start+1,len(s)+1):
                if s[start:i] in wordDict and helper(i):
                    return True
            return False
        return helper(0)
