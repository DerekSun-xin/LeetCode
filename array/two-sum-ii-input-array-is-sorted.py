class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i = 0
        j = len(numbers)-1
        ret = []
        
        while i<j:
            sm = numbers[i]+numbers[j]
            if sm == target:
                ret.append(i+1)
                ret.append(j+1)
                return ret
            elif sm >target:
                j-=1
            else:
                i+=1
        return []
        