# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        tmp = head
        ls = list()
        while tmp:
            ls.append(tmp.val)
            tmp = tmp.next
        i,j = 1,len(ls)-1
        head1 = head

        
        while i<j:
            head1.next = ListNode(ls[j])
            head1 = head1.next
            head1.next = ListNode(ls[i])
            head1 = head1.next
            i+=1
            j-=1
            if i ==j:
                head1.next = ListNode(ls[i])
                break

            

            

        