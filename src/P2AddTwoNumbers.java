/**
 * Created by xilingyuli on 2017/1/27.
 */
public class P2AddTwoNumbers {
    int mov = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+mov;
        ListNode ans = new ListNode(sum%10);
        mov = sum/10;
        if((l1!=null&&l1.next!=null)||(l2!=null&&l2.next!=null)||mov!=0)
            ans.next = addTwoNumbers((l1!=null?l1.next:null),(l2!=null?l2.next:null));
        return ans;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
