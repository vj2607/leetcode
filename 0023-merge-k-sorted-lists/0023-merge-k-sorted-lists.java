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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
          for(ListNode node :lists){
             while(node!=null){
                pq.add(node.val);
                node=node.next;
             }
          }
          ListNode ansNode = new ListNode(0);
          ListNode temp = ansNode;
          while(!pq.isEmpty()){
              temp.next = new ListNode(pq.poll());
              temp= temp.next;
          }

          return ansNode.next;
    }
}