# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def arrayToTree(start,end):
            nonlocal postOrderIndex
            if start>end:
                return None
            
            root = TreeNode(postorder[postOrderIndex])
            rootInorderIndex = memo[postorder[postOrderIndex]]
            postOrderIndex-=1
            root.right = arrayToTree(rootInorderIndex+1,end)
            root.left = arrayToTree(start,rootInorderIndex-1)
            return root

        memo = dict()
        postOrderIndex = len(postorder)-1
        for i in range(len(inorder)):
            memo[inorder[i]] = i
        
        return arrayToTree(0,len(postorder)-1)

            