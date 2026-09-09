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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true){

            ListNode kth = getKth(groupPrev, k);

            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode current = groupPrev.next;

            while(current != groupNext){

                ListNode next = current.next;

                current.next = prev;
                prev = current;
                current = next;
            }

            ListNode oldGroupStart = groupPrev.next;

            groupPrev.next = kth;
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    public ListNode getKth(ListNode curr, int k){

        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }

        return curr;
    }
}