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
    public ListNode partition(ListNode head, int x) {
    
        ListNode lessDummy = new ListNode(0);
        ListNode greatDummy = new ListNode(0);

        ListNode lessCurrent = lessDummy;
        ListNode greatCurrent = greatDummy;

        ListNode current = head;

        while(current != null){

            if(current.val < x){
                lessCurrent.next = current;
                lessCurrent = lessCurrent.next;
            }
            else{
                greatCurrent.next = current;
                greatCurrent = greatCurrent.next;
            }

            current = current.next;
        }

        greatCurrent.next = null;
        lessCurrent.next = greatDummy.next;

        return lessDummy.next;
    }
}