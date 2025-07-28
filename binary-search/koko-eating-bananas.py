class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low = 1
        high = max(piles)
        benchmark = (low+high)//2
        mid = 0
        while high>=low:
            mid = (low+high)//2
        
            if Solution.isValid(self,piles,mid,h) == True:
                if mid-1>0:
                    if Solution.isValid(self,piles,mid-1,h) != True:
                        break
                if mid>benchmark:
                    break
                high = mid-1
            else:
                low = mid+1
        
        return mid
    
    def isValid(self,piles,mid,h):
        num = 0
        for pile in piles:
            if pile<=mid:
                num+=1
            else:
                if pile%mid==0:
                    num+=pile//mid
                else:
                    num+=pile//mid+1
        if num<=h:
            return True
        else:
            return False
            
            