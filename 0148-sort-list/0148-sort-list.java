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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
           return head;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp=head;

        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(arr);
        ListNode newHead = new ListNode(arr.get(0));
        ListNode temp1 = newHead;

        for(int i=1;i<arr.size();i++){
              ListNode curr = new ListNode(arr.get(i));
              temp1.next=curr;
              temp1=curr;
        }

        return newHead;
    }
}