class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left,right=0,0
        n = len(s)
        num = [0]*26
        maxn = 0
        while right<n:
            num[ord(s[right])-ord("A")]+=1
            maxn = max(maxn,num[ord(s[right])-ord("A")])
            if right-left+1>maxn+k:
                num[ord(s[left])-ord("A")]-=1
                left+=1
            right+=1
        return (right-1)-left+1
