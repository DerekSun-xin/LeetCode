# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def height(self,root): 
        if root == None:
            return 0 
        return 1 + max(self.height(root.left), self.height(root.right)) 

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        # Check if subtrees have height difference within 1.
        # If they do, check if the subtrees are balanced
        return abs(self.height(root.left) - self.height(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)
