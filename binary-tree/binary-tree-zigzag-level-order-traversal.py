# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return []
        comb = []
        current_level = []
        next_level = [root]
        index = 0

        while len(next_level)!=0:
            current_level = next_level
            next_level = []
            comb.append([])
            index+=1
            for node in current_level:
                comb[-1].append(node.val)
            current_level.reverse()
            for node in current_level:
                if index%2==1:
                    if node.right:
                        next_level.append(node.right)
                    if node.left:
                        next_level.append(node.left)
                else:
                    if node.left:
                        next_level.append(node.left)
                    if node.right:
                        next_level.append(node.right)

        return comb
            
            