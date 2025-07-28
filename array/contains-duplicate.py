class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # Sorting
        nums.sort()
        # After sorting, if there are any duplicates, they will be consecutive after sorting
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                return True
        return False
        