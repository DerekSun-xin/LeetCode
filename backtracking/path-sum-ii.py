# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        comb = []
        def isleafNode(root):
                if root.left==None and root.right==None:
                    return True
                else:
                    return False
         
        def backtracking(root,path,sum):
            if root==None:
                return 
            if isleafNode(root):
                sum+=root.val
                if sum == targetSum:
                    path.append(root.val)
                    comb.append(list(path))
                    path.pop()
                    return
                else:
                    return 
            
            path.append(root.val)
            sum+=root.val
            backtracking(root.left,path,sum)
            backtracking(root.right,path,sum)
            path.pop()
            return

            '''
                        if root == None and sum==targetSum:
                            comb.append(list(path))
                            return
                        if root == None:
                            return  
                        sum+=root.val
                        path.append(root.val)
                        print(path)
                        backtracking(root.left,path,sum)
                        backtracking(root.right,path,sum)
                        path.pop()
                        return '''
        backtracking(root,[],0)
        return comb