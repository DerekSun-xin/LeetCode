class Solution:
    def rob(self, nums: List[int]) -> int:
        return max(nums[0],self.helper(nums,nums[1:]), self.helper(nums,nums[:-1]))

    def helper(self,nums,subStr):
        rob1, rob2 = 0, 0
        for i in range(len(subStr)):
            newRob = max(rob1 + subStr[i], rob2) 
            rob1 = rob2 
            rob2 = newRob 
        return rob2 
        
