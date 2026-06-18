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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ans=new ListNode();
        ListNode p=ans;
        while(l1!=null || l2!=null){
            int sum=0;
            if(l1!=null) {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carry;
            if(sum>9) carry=1;
            else carry=0;
            sum%=10;

            p.next=new ListNode(sum);
            p=p.next;
        }
        if(carry!=0) p.next=new ListNode(carry);
        
        return ans.next;
    }
}