class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        rp = -1
        n=len(s)
        tmp = set()
        ans = 0
        for lp in range(n):
            if lp!=0:
                tmp.remove(s[lp-1])
            while rp+1<n and s[rp+1] not in tmp:
                tmp.add(s[rp+1])
                rp+=1
            ans = max(ans,rp-lp+1)
        return ans