# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Inorder traversal of BST is an array sorted in ascending order. 
        ret = []
        def in_order(node): 
            if node is None:
                return 
            in_order(node.left)
            ret.append(node.val)
            in_order(node.right)
        in_order(root)
        return ret[k-1] 
