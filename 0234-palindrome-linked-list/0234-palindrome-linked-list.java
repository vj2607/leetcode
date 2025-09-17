/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
         ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
           
        }
        ListNode second = reverse(slow);
        ListNode temp=head;

        while(second!=null){
            if(second.val!=temp.val)
             return false;
             second=second.next;
             temp=temp.next;

        }
        return true;
    }
     ListNode reverse(ListNode head){

        if(head==null || head.next==null)
          return head;

        ListNode newHead= reverse(head.next);

       ListNode temp= head.next;
          temp.next=head;
          head.next=null;

          return newHead;
     }
        
}