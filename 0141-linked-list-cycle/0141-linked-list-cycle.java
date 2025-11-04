/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head){
         if(head==null) return false;
           ListNode slowPointer=head;
           ListNode fastPointer=head.next;

           while(fastPointer!=null&&fastPointer.next!=null){
                    if(slowPointer==fastPointer) return true;
                    slowPointer=slowPointer.next;
                    fastPointer=fastPointer.next.next;

           }
           return false;


    }
    // public boolean hasCycle(ListNode head) {

    //   Set<ListNode> set=new HashSet<>();
    //   ListNode current=head;
    //   while(current!=null){
    //       if(set.contains(current)) return true;
    //       set.add(current);
    //       current=current.next;
    //   }
    //   return false;


        
        
    // }
}
