class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        def find_rotation_index(left,right):
            if nums[left]<nums[right]:
                '''means there is no rotation'''
                return 0;
            
            while left<=right:
                pivot = (left+right)//2
                if nums[pivot]>nums[pivot+1]:
                    return pivot+1
                else:
                    if nums[pivot]<nums[left]:
                        right = pivot-1
                    else:
                        left = pivot + 1

        def search(left,right):
            '''Binary Search'''
            while left<=right:
                pivot = (left+right)//2
                if nums[pivot] == target:
                    return pivot
                else:
                    if target<nums[pivot]:
                        right = pivot-1
                    else:
                        left = pivot+1
            return -1

        '''Implementation of functions'''
        n = len(nums)
        if n==1:
            if nums[0] == target:
                return 0
            else:
                return -1

        rotation_index = find_rotation_index(0,n-1);
        if nums[rotation_index] == target:
            return rotation_index
        
        '''Vector is not rotated''' 
        if rotation_index ==0:
            return search(0,n-1)
        
        if target<nums[0]:
            return search(rotation_index+1,n-1)
        else:
            return search(0,rotation_index-1)
        
            