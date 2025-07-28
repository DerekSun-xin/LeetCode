# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0 
         
        q = collections.deque()
        self.count_good = 0
        # (cur_node, max value from root to cur_node)
        q.append((root,-pow(10,4))) 
        while q: 
            cur,tmp_max = q.popleft()
            if cur.val >= tmp_max: 
                tmp_max = cur.val
                self.count_good+=1
            if cur.left is not None:
                q.append((cur.left,tmp_max)) 
            if cur.right is not None: 
                q.append((cur.right,tmp_max)) 
        return self.count_good



            
                    
        