class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        def backtrack(path,index): 
            if index == len(nums): 
                if path not in output:
                    output.append(list(path)) 
                return 
            
            backtrack(path, index + 1)
            path.append(nums[index])
            backtrack(path, index + 1)
            path.pop()
        
        output = []
        backtrack([],0)
        return output 