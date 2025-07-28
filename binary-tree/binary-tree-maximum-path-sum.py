# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.res = -math.inf 
        def dfs(node):
            if node is None:
                return 0 
            left = dfs(node.left)
            right = dfs(node.right)
            value, ret = node.val, node.val 
            if left >= 0 and right >= 0 : 
                value += left + right 
                ret = node.val + max(left,right) 
            elif left < 0 and right >= 0: 
                value += right
                ret += right
            elif left >= 0 and right < 0: 
                value += left 
                ret += left
            self.res = max(self.res, value)
            return ret 
        dfs(root)
        return self.res
            


            
            

        