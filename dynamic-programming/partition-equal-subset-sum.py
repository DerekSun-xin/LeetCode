class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums)%2:
            return False
        
        target = sum(nums)//2
        sum_set = set([0])

        for i in range(len(nums)-1,-1,-1):
            tmp_set = set()
            for t in sum_set:
                tmp_set.add(t+nums[i])
                tmp_set.add(t)
                if t+nums[i] == target:
                    return True
            sum_set = tmp_set
        return False

        
        