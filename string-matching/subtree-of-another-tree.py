# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is not None: 
            check = self.isSameTree(root,subRoot)
            return check or self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot)
        return False
            
    def isSameTree(self,p,q):
        if p is None and q is None: 
            return True
        elif p is not None and q is None:
            return False
        elif p is None and q is not None:
            return False
        elif p.val != q.val:
            return False
        else:
            return self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)
        