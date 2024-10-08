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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenTemp = evenHead;
        while(evenTemp != null && evenTemp.next != null){
            oddHead.next = evenTemp.next;
            oddHead = oddHead.next;
            evenTemp.next = oddHead.next;
            evenTemp = evenTemp.next;
        }
        oddHead.next = evenHead;
        return head;
    }
}