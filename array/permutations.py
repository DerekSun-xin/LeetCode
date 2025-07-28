class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        output = []
        def backtrack(path): 
            if len(path) == len(nums): 
                output.append(list(path))
                return 
            
            for i in range(len(nums)):
                if nums[i] not in path: 
                    path.append(nums[i]) 
                    backtrack(path)
                    path.pop() 
        backtrack([])

        return output 