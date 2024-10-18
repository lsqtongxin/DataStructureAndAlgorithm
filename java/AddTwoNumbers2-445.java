// 1. 反转链表，然后顺序求和，最后再反转结果，返回即可
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode l1re = reverseNode(l1);
        ListNode l2re = reverseNode(l2);
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode dummy = new ListNode();
        dummy1.next = l1re;
        dummy2.next = l2re;
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = dummy;
        int carry = 0;
        while(cur1.next!=null && cur2.next!=null){
            int temp = cur1.next.val + cur2.next.val + carry;
            carry = 0;
            ListNode tempNode = new ListNode();
            if(temp>=10){
                carry = temp/10;
                tempNode.val = temp%10;
            }else {
                tempNode.val = temp;
            }
            cur.next = tempNode;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next;
        }
        while(cur1.next!=null){
            int temp = cur1.next.val + carry;
            carry = 0;
            ListNode tempNode = new ListNode();
            if(temp>=10){
                carry = temp/10;
                tempNode.val = temp%10;
            }else {
                tempNode.val = temp;
            }
            cur.next = tempNode;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while(cur2.next!=null){
            int temp = cur2.next.val + carry;
            carry = 0;
            ListNode tempNode = new ListNode();
            if(temp>=10){
                carry = temp/10;
                tempNode.val = temp%10;
            }else {
                tempNode.val = temp;
            }
            cur.next = tempNode;
            cur2 = cur2.next;
            cur = cur.next;
        }
        if(carry!=0){
            cur.next = new ListNode(carry);
        }
        return reverseNode(dummy.next);
    }

    public ListNode reverseNode(ListNode l){
        if(l==null)return l;
        ListNode dummy = new ListNode();
        dummy.next = l;
        ListNode cur = dummy;
        ListNode dummyAns = new ListNode();
        while(cur.next!=null){
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = dummyAns.next;
            dummyAns.next = temp;
        }
        return dummyAns.next;
    }
}
