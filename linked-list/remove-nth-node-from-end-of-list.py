# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if n==0: return head

        ls = list()
        tmp = head
        while tmp:
            ls.append(tmp.val)
            tmp=tmp.next
        
        if len(ls)==n:return head.next
   
        i=1
        target = len(ls)-n
        tmp = head

        while i<target:
            tmp = tmp.next
            i+=1

        if tmp.next.next:
            tmp.next = tmp.next.next
        else:
            tmp.next = None
        
        return head

        

