class Solution:
    def isPalindrome(self, s: str) -> bool:
        phase = ""
        for i in range(len(s)):
            if s[i].isalpha() or s[i].isnumeric():
                phase+=s[i]
        phase = phase.lower()
        print(phase)
        n = len(phase)
       
        if n==0:
            return True
        second = n-1
        for first in range(0,n//2):
           
            if phase[first]==phase[second]:
                second-=1
            else:
                return False
        return True

        
