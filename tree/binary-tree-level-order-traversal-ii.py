# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        comb = []
        def backtracking(root,index):
            if root == None:
                return 
            
            if len(comb)==index:
                ls = [root.val]
                comb.append(list(ls))
            else:
                comb[index].append(root.val)
            index+=1
            backtracking(root.left,index)
            backtracking(root.right,index)
            return 
        backtracking(root,0)

        comb.reverse()
        return comb


            