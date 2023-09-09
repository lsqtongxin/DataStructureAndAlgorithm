class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    ListNode dummy;
    int length;
    public MyLinkedList() {
        dummy = new ListNode(0);
        length = 0;
    }
    
    public int get(int index) {
        if(index<0 || index>=length)return -1;
        ListNode cur = dummy;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.next.val;
    }
    
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = dummy.next;
        dummy.next = temp;
        length++;
    }
    
    public void addAtTail(int val) {
        ListNode cur = dummy;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>length)return;
        ListNode cur = dummy;
        while(index>0){
            cur=cur.next;
            index--;
        }
        ListNode temp = new ListNode(val);
        temp.next = cur.next;
        cur.next = temp;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=length)return;
        ListNode cur = dummy;
        while(index>0){
            cur=cur.next;
            index--;
        }
        ListNode temp = cur.next;
        cur.next = temp.next;
        temp.next = null;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */