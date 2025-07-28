# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashmap = {num:i for i,num in enumerate(inorder)}
        length = len(preorder) 
        def construct_tree(i,l,r): 
            if l not in range(length) or r not in range(length) or i not in range(length) or l > r: 
                return 
            
            root = TreeNode(preorder[i])
            m = hashmap[root.val]
            root.left = construct_tree(i + 1,l,m-1)
            root.right = construct_tree(i+1+m-l, m+1,r)
            return root
        return construct_tree(0,0,length-1)        