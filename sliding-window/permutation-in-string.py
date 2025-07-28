class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1)>len(s2): return False

        s1count = [0]*26
        s2count = [0]*26

        for i in range(len(s1)):
            s1count[ord(s1[i]) - ord('a')]+=1
            s2count[ord(s2[i]) - ord('a')]+=1
        
        match = sum(map(lambda i: s1count[i] == s2count[i], range(26)))

        for i in range(len(s2)-len(s1)):
            if match == 26:
                return True
            
            #remove the left side
            s2count[ord(s2[i])-ord('a')] -=1
            if s2count[ord(s2[i]) - ord('a')] == s1count[ord(s2[i]) - ord('a')]:
                match+=1
            elif s2count[ord(s2[i])-ord('a')]+1 == s1count[ord(s2[i]) - ord('a')]:
                match-=1

            #add the right side
            r = s2[i+len(s1)]
            s2count[ord(r)-ord('a')] +=1
            if s2count[ord(r) - ord('a')] == s1count[ord(r) - ord('a')]:
                match+=1
            elif s2count[ord(r)-ord('a')]-1 == s1count[ord(r) - ord('a')]:
                match-=1
        
        return match==26