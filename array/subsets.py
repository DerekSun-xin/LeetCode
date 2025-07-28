class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        def subset(num,index,path):
            if len(path)==num:
                ret.append(list(path))
                return

            for i in range(index,len(nums)):
                path.append(nums[i])
                subset(num,i+1,path)
                path.remove(nums[i])
            return 
        ret = []
        for i in range(len(nums)+1):
            subset(i,0,[])
        return ret
    
