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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null||k==0){
            return head;
           }
       ListNode node =head;
        int count=1 ;
        while(node.next !=null){
          
            node = node.next;
            count++;
        }
         k =k%count;
         if(k==0)
         return head;

         node.next=head;
         node=head;
         for(int i=1;i<count-k;i++){
            node=node.next;
         }

         head=node.next;
         node.next=null;
        

        return head;

    }

   
}