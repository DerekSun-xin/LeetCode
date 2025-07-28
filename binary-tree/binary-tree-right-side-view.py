# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        visited = set()
        q = collections.deque()
        q.append((root,0))
        ret = [root.val]
        self.check_height = 1 
        while q:
            cur,height = q.popleft()
            if cur.right is not None: 
                q.append((cur.right,height + 1)) 
                if self.check_height == height + 1:
                    ret.append(cur.right.val) 
                    self.check_height+=1 
            if cur.left is not None: 
                q.append((cur.left, height + 1)) 
                if self.check_height == height + 1:
                    ret.append(cur.left.val) 
                    self.check_height+=1 
        return ret
                
        

                
            

            
        return ret


        