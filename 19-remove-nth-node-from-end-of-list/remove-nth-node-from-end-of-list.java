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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans=head;
        ListNode prev=null;
        ListNode curr=head;
        for(int i=1;i<n;i++){
            curr=curr.next;
        }
        if(curr.next==null) return head.next;//edge case,...
        prev=head;
        boolean first=false;
        while(curr.next!=null){
            curr=curr.next;
            if(first) prev=prev.next;
            first=true;
        }
        prev.next=prev.next.next;
        return head;
    }
}