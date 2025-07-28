# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        root_to_leaf = 0
        stack = [(root,0)]
        while stack:
            root,current_num = stack.pop()
            if root!=None:
                current_num = current_num*10+root.val
                if root.left ==None and root.right==None:
                    root_to_leaf+=current_num
                else:
                    stack.append((root.left,current_num))
                    stack.append((root.right,current_num))
        return root_to_leaf
