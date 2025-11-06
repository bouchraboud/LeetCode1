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

         if (lists == null || lists.length == 0) return null;
         PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);//hnaya bach nspesifiw wach min ola max obach ghan9arno (val) 
         //minHeap.offer();
         //minHeap.poll();
         ListNode dummy=new ListNode(0);
         ListNode current=dummy;
         
         for(int i=0;i<lists.length;i++){
            minHeap.offer(lists[i]);

         }

         while(!minHeap.isEmpty()){
            ListNode root= minHeap.poll();
            current.next=root;
            if(root.next!=null) minHeap.offer(root.next);
            current=current.next;


         }

         return dummy.next;


    }
}
