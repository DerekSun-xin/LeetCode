class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        ret = 0
        g.sort()
        s.sort()
        for i in range(len(g)):
            j = 0
            while j<len(s):
                if s[j]>=g[i]:
                    ret+=1
                    s.pop(j)
                    break    
                j+=1
        return ret
                