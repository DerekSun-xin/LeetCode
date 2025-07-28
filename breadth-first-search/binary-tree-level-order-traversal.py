# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = collections.deque()
        q.append((root,0))
        ret = [[root.val]]
        while q:
            cur,height = q.popleft() 
            if cur.left is not None: 
                q.append((cur.left,height+1)) 
                if len(ret) == height+1:      
                    ret.append([cur.left.val])        
                else: 
                    ret[height+1].append(cur.left.val)
            if cur.right is not None:
                q.append((cur.right,height+1))
                if len(ret) == height+1:
                    ret.append([cur.right.val])
                else:
                    ret[height+1].append(cur.right.val)           
        return ret
        